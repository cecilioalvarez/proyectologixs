package es.logixs.repository.mysql;

import es.logixs.config.DataBaseHelper;
import es.logixs.domain.Companies;
import es.logixs.repository.CompaniesRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompaniesRepositoryMySQL implements CompaniesRepository {

    private final static String sqlInsert = "insert into companies (objectid,code,licenseId,name,taxId) values (?,?,?,?,?)";
    private final static String sqlFindAll = "select * from companies";
    private final static String sqlDelete = "delete from companies where objectid=?";
    private final static String sqlFindOne= "select * from companies where objectid=?";


    @Override
    public Companies insert(Companies company) {

        try (Connection conexion = new  DataBaseHelper().getConexion("mySQL");
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

    @Override
    public void delete(Companies company) {

        try (Connection conexion = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sqlDelete);) {
            sentencia.setString(1, company.getObjectid());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Companies> findAll() {


        List<Companies> lista = new ArrayList<Companies>();

        try (Connection conn = new  DataBaseHelper().getConexion("mySQL");
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

    @Override
    public Companies findOne(String objectid) {


        Companies company = null;

        try (Connection conn = new  DataBaseHelper().getConexion("mySQL");
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