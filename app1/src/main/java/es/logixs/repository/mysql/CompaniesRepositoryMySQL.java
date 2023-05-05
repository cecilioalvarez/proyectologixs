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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompaniesRepositoryMySQL implements CompaniesRepository {

    private final static String sqlInsert = "insert into companies (objectid,code,licenseId,name,taxId) values (?,?,?,?,?)";
    private final static String sqlFindAll = "select * from companies";
    private final static String sqlDelete = "delete from companies where objectid=?";
    private final static String sqlFindOne= "select * from companies where objectid=?";
    private static final Logger loggingTool= LogManager.getLogger(CompaniesRepositoryMySQL.class.getName());

    @Override
    public Companies insert(Companies company) {
        loggingTool.info("Companies.insert() is called");
        loggingTool.warn("The fields must be filled {}",company);

        try (Connection conexion = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sqlInsert);) {
            sentencia.setString(1, company.getObjectid());
            sentencia.setString(2, company.getCode());
            sentencia.setString(3, company.getLicenseId());
            sentencia.setString(4, company.getName());
            sentencia.setString(5, company.getTaxId());
            sentencia.executeUpdate();

            loggingTool.debug("Inserted company result: {},{},{},{},{}",company.getObjectid(),company.getCode(),company.getLicenseId(),company.getName(),company.getTaxId());
        } catch (SQLException e) {

            loggingTool.error("An error has occurred :", e);
        }
        return company;
    }

    @Override
    public void delete(Companies company) {
        loggingTool.info("Companies.delete() is called");
        loggingTool.warn("Attempting to delete {}",company);


        try (Connection conexion = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sqlDelete);) {
            sentencia.setString(1, company.getObjectid());
            sentencia.executeUpdate();
            loggingTool.debug("Object company has an state of {}:",company);
        } catch (SQLException e) {

            loggingTool.error("An error has occurred :", e);

        }
    }

    @Override
    public List<Companies> findAll() {
        loggingTool.info("Companies.findAll() is called");

        List<Companies> lista = new ArrayList<Companies>();
        loggingTool.warn("The fields must not be empty {}",lista);

        try (Connection conn = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement(sqlFindAll);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                lista.add(new Companies(rs.getString("objectid"),rs.getString("code"),rs.getString("licenseId"),rs.getString("name"),rs.getString("taxId")));
            }
            loggingTool.debug("List size is : {} The elements are {}",lista.size(),lista);

        } catch (SQLException e) {

            loggingTool.error("An error has occurred :", e);
        }
        return lista;
    }

    @Override
    public Companies findOne(String objectid) {

        loggingTool.info("Companies.findOne() is called");
        loggingTool.warn("Attempting to find company with identifier {}",objectid);

        Companies company = null;

        try (Connection conn = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement(sqlFindOne);

        ) {
            stmt.setString(1, objectid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    company = new Companies(rs.getString("objectid"),rs.getString("code"),rs.getString("licenseId"),rs.getString("name"),rs.getString("taxId"));

            }
            loggingTool.debug("Found company result: {},{},{},{},{}",company.getObjectid(),company.getCode(),company.getLicenseId(),company.getName(),company.getTaxId());


        } catch (SQLException e) {

            loggingTool.error("An error has occurred :", e);
        }
        return company;
    }

}
