package es.logixs.repository.mysql;

import es.logixs.config.DataBaseHelper;
import es.logixs.domain.Requests;
import es.logixs.repository.RequestsRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestRepositoryMySQL implements RequestsRepository {
    private final static String sqlInsert = "insert into Requests (code, offerId, ownerId, companyId) values (?,?,?,?);";
    private final static String sqlDelete = "delete from Requests where id=?";
    private final static String sqlFindAll = "select * from Requests;";
    private final static String sqlFindOne = "select * from Requests where id=?;";

    @Override
    public Requests insert(Requests requests) {
        try (Connection connection = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement sentence = connection.prepareStatement(sqlInsert);) {
            sentence.setString(1, requests.getCode());
            sentence.setString(2, requests.getOfferId());
            sentence.setString(3, requests.getOwnerId());
            sentence.setString(4, requests.getCompanyId());
            sentence.executeUpdate();
        } catch (SQLException e) {

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
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return requests;
    }

    @Override
    public void delete(String id) {
        try (Connection connection = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement sentence = connection.prepareStatement(sqlDelete);) {
            sentence.setString(1, id);
            sentence.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
