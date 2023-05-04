package es.logixs.repository;

import es.logixs.config.DataBaseHelper;
import es.logixs.domain.Companies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompaniesRepositoryMySQL {

    private final static String sqlInsert = "insert into Companies (objectid,code,licenseId,name,taxId) values (?,?,?,?,?)";
    private final static String sqlFindAll = "select * from Companies";
    private final static String sqlDelete = "delete from Companies where objectid=?";
    private final static String sqlFindOne= "select * from Companies where objectid=?";



    public Companies insert(Companies company) {

        try (Connection conexion = DataBaseHelper.getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sqlInsert);) {
            sentencia.setString(1, company.getObjectid());
            sentencia.setString(2, company.getCode());
            sentencia.setString(3, company.getLicenseId());
            sentencia.setString(4, company.getName());
            sentencia.setString(5, company.getTaxId());
            sentencia.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return company;
    }

    public void delete(Companies company) {

        try (Connection conexion = DataBaseHelper.getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sqlDelete);) {
            sentencia.setString(1, company.getObjectid());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            throw new RuntimeException(e);
        }
    }

    public List<Companies> findAll() {


        List<Companies> lista = new ArrayList<Companies>();

        try (Connection conn = DataBaseHelper.getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement(sqlFindAll);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                lista.add(new Companies(rs.getString("objectid"),rs.getString("code"),rs.getString("licenseId"),rs.getString("name"),rs.getString("taxId")));
            }

        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Companies findOne(String objectid) {


        Companies company = null;

        try (Connection conn = DataBaseHelper.getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement(sqlFindOne);

        ) {
            stmt.setString(1, objectid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    company = new Companies(rs.getString("objectid"),rs.getString("code"),rs.getString("licenseId"),rs.getString("name"),rs.getString("taxId"));

            }

        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            throw new RuntimeException(e);
        }
        return company;
    }

}
