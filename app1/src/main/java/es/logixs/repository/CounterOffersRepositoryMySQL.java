package es.logixs.repository;

import es.logixs.config.DataBaseHelper;
import es.logixs.domain.CounterOffers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CounterOffersRepositoryMySQL implements CounterOffersRepository {

    @Override
    public CounterOffers insert(CounterOffers counterOffer) {
        String query = "insert into CounterOffers (id,name,vom,originalPrice,counterOfferPrice,quantity) values(?,?,?,?,?,?)";

        try (
            Connection connection = DataBaseHelper.getConexion("mySQL");
            PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setInt(1, counterOffer.getId());
            statement.setString(2, counterOffer.getName());
            statement.setString(3, counterOffer.getVom());
            statement.setDouble(4, counterOffer.getOriginalPrice());
            statement.setDouble(5, counterOffer.getCounterOfferPrice());
            statement.setDouble(6, counterOffer.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return counterOffer;
    }

    @Override
    public CounterOffers update(CounterOffers counterOffer) {
        return null;
    }

    @Override
    public void delete(CounterOffers counterOffer) {

    }


    @Override
    public CounterOffers findOne(int id) {
        return null;
    }

    @Override
    public List<CounterOffers> findAll() {
        return null;
    }
}
