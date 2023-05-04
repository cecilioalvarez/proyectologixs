package es.logixs.repository;

import es.logixs.config.DataBaseHelper;
import es.logixs.domain.Offer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfferRepositoryMySQL implements OfferRepository{

    @Override
    public Offer insert(Offer offer) {
        String sql = "insert into offer (id,code,name,description,category) values (?,?,?,?,?)";

        try (Connection connection = DataBaseHelper.getConexion("mySQL");
             PreparedStatement query = connection.prepareStatement(sql)) {
            query.setInt(1, offer.getId());
            query.setString(2, offer.getCode());
            query.setString(3, offer.getName());
            query.setString(4, offer.getDescription());
            query.setString(5, offer.getCategory());
            query.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return offer;
    }

    @Override
    public void delete(Offer offer) {
        String sql = "delete from offer where id=?";

        try (Connection connection = DataBaseHelper.getConexion("mySQL");
             PreparedStatement query = connection.prepareStatement(sql)) {
            query.setInt(1, offer.getId());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Something went wrong.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Offer findOne(int id) {
        Offer offer = null;

        try (Connection conn = DataBaseHelper.getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement("select * from offer where id=?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    offer = new Offer(rs.getInt("id"), rs.getString("code"), rs.getString("name"), rs.getString("description"), rs.getString("category"));

            }

        } catch (

            SQLException e) {
            System.out.println("Something went wrong.");
            throw new RuntimeException(e);
        }
        return offer;
    }

    @Override
    public List<Offer> findAll() {
        List<Offer> list = new ArrayList<>();

        try (Connection conn = DataBaseHelper.getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement("select * from offer");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                list.add(new Offer(rs.getInt("id"), rs.getString("code"), rs.getString("name"), rs.getString("description"), rs.getString("category")));
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong.");
            throw new RuntimeException(e);
        }
        return list;
    }
}
