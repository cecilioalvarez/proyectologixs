package es.logixs.repository.mysql;

import es.logixs.App;
import es.logixs.config.DataBaseHelper;
import es.logixs.domain.Requests;
import es.logixs.repository.RequestsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestRepositoryMySQL implements RequestsRepository {
    private final static String sqlInsert = "insert into Requests (code, offerId, ownerId, companyId) values (?,?,?,?);";
    private final static String sqlDelete = "delete from Requests where id=?";
    private final static String sqlFindAll = "select * from Requests;";
    private final static String sqlFindOne = "select * from Requests where id=?;";
    private static final Logger myLogger= LogManager.getLogger(App.class);

    @Override
    public Requests insert(Requests requests) {
        try (Connection connection = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement sentence = connection.prepareStatement(sqlInsert);) {
            myLogger.info("Insertando una solicitud " + requests.toString());
            sentence.setString(1, requests.getCode());
            sentence.setString(2, requests.getOfferId());
            sentence.setString(3, requests.getOwnerId());
            sentence.setString(4, requests.getCompanyId());
            sentence.executeUpdate();
        } catch (SQLException e) {
            myLogger.error("Error al insertar una solicitud " + e.getMessage());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return requests;
    }

    @Override
    public Requests findOne(String id) {
        Requests requests = null;
        try (Connection connection = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement sentence = connection.prepareStatement(sqlFindOne);) {
            myLogger.info("Buscando una solicitud con id " + id);
            sentence.setString(1, id);
            ResultSet result = sentence.executeQuery();
            if (result.next()) {
                requests = new Requests(result.getString("id"));
                requests.setCode(result.getString("code"));
                requests.setOfferId(result.getString("offerId"));
                requests.setOwnerId(result.getString("ownerId"));
                requests.setCompanyId(result.getString("companyId"));
            }
        } catch (SQLException e) {
            myLogger.error("Error al buscar una solicitud con id " + id + " " + e.getMessage());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return requests;
    }

    @Override
    public List<Requests> findAll() {
        List<Requests> requests = new ArrayList<>();
        try (Connection connection = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement sentence = connection.prepareStatement(sqlFindAll);) {
            myLogger.info("Buscando todas las solicitudes");
            ResultSet result = sentence.executeQuery();
            while (result.next()) {
                Requests request = new Requests(result.getString("id"));
                request.setCode(result.getString("code"));
                request.setOfferId(result.getString("offerId"));
                request.setOwnerId(result.getString("ownerId"));
                request.setCompanyId(result.getString("companyId"));
                requests.add(request);
            }
        } catch (SQLException e) {
            myLogger.error("Error al buscar todas las solicitudes " + e.getMessage());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return requests;
    }

    @Override
    public void delete(String id) {
        try (Connection connection = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement sentence = connection.prepareStatement(sqlDelete);) {
            myLogger.info("Eliminando una solicitud con id " + id);
            sentence.setString(1, id);
            sentence.executeUpdate();
        } catch (SQLException e) {
            myLogger.error("Error al eliminar una solicitud con id " + id + " " + e.getMessage());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
