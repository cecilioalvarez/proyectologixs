package es.logixs.repository.mysql;

import es.logixs.config.DataBaseHelper;
import es.logixs.domain.Offer;
import es.logixs.repository.OfferRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfferRepositoryMySQL implements OfferRepository {

    private static final Logger logger = LogManager.getLogger(OfferRepositoryMySQL.class);

    @Override
    public Offer insert(Offer offer) {
        String sql = "insert into offer (id,code,name,description,category) values (?,?,?,?,?)";
        logger.info("Trying to insert Offer with objectid: {}", offer.getId());
        try (Connection connection = new DataBaseHelper().getConexion("mySQL");
             PreparedStatement query = connection.prepareStatement(sql)) {
            query.setInt(1, offer.getId());
            query.setString(2, offer.getCode());
            query.setString(3, offer.getName());
            query.setString(4, offer.getDescription());
            query.setString(5, offer.getCategory());
            query.executeUpdate();
            logger.info("Offer inserted with ID " + offer.getId());
        } catch (SQLException e) {
            logger.error("Error while inserting offer with ID " + offer.getId(), e);
            throw new RuntimeException(e);
        }
        return offer;
    }

    @Override
    public void delete(Offer offer) {
        String sql = "delete from offer where id=?";
        logger.info("Trying to delete Offer with objectid: {}", offer.getId());
        try (Connection connection = new DataBaseHelper().getConexion("mySQL");
             PreparedStatement query = connection.prepareStatement(sql)) {
            query.setInt(1, offer.getId());
            query.executeUpdate();
            logger.info("Offer deleted with ID " + offer.getId());
        } catch (SQLException e) {
            logger.error("Error while deleting offer with ID " + offer.getId(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Offer findOne(int id) {
        Offer offer = null;
        logger.info("Trying to find Offer with objectid: {}", id);
        try (Connection conn = new DataBaseHelper().getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement("select * from offer where id=?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    offer = new Offer(rs.getInt("id"), rs.getString("code"), rs.getString("name"), rs.getString("description"), rs.getString("category"));
                logger.info("Offer found with ID " + id);
            }

        } catch (SQLException e) {
            logger.error("Error while finding offer with ID " + id, e);
            throw new RuntimeException(e);
        }
        return offer;
    }

    @Override
    public List<Offer> findAll() {
        List<Offer> list = new ArrayList<>();
        logger.info("Trying to find all Offers");
        try (Connection conn = new DataBaseHelper().getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement("select * from offer");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                list.add(new Offer(rs.getInt("id"), rs.getString("code"), rs.getString("name"), rs.getString("description"), rs.getString("category")));
            }
            logger.info("All offers retrieved successfully");
        } catch (SQLException e) {
            logger.error("Error while retrieving offers", e);
            throw new RuntimeException(e);
        }
        return list;
    }
}
