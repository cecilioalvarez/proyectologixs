package es.logixs.repository.mysql;

import es.logixs.config.DataBaseHelper;
import es.logixs.domain.CounterOffers;
import es.logixs.repository.CounterOffersRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CounterOffersRepositoryMySQL implements CounterOffersRepository {

    
    @Override
    public CounterOffers insert(CounterOffers counterOffer) {
        String query = "insert into counter_offers (id,name,vom,originalPrice,counterOfferPrice,quantity) values(?,?,?,?,?,?)";

        try (
            Connection connection = new  DataBaseHelper().getConexion("mySQL");
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
        String query = "update counter_offers set name=? ,vom=? ,originalPrice=? ,counterOfferPrice=? ,quantity=? where id=?";

        try (
            Connection connection = new  DataBaseHelper().getConexion("mySQL");
            PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, counterOffer.getName());
            statement.setString(2, counterOffer.getVom());
            statement.setDouble(3, counterOffer.getOriginalPrice());
            statement.setDouble(4, counterOffer.getCounterOfferPrice());
            statement.setDouble(5, counterOffer.getQuantity());
            statement.setInt(6, counterOffer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return counterOffer;
    }

    @Override
    public void delete(CounterOffers counterOffer) {
        String query = "delete from counter_offers where id = ?";

        try (
            Connection connection = new  DataBaseHelper().getConexion("mySQL");
            PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setInt(1, counterOffer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public CounterOffers findOne(int id) {
        CounterOffers counterOffer = null;
        String sql = "select * from counter_offers where id = ?";

        try (
            Connection connection = new  DataBaseHelper().getConexion("mySQL");
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                counterOffer = new CounterOffers(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("vom"),
                    result.getDouble("originalPrice"),
                    result.getDouble("counterOfferPrice"),
                    result.getDouble("quantity")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return counterOffer;
    }

    @Override
    public List<CounterOffers> findAll() {
        List<CounterOffers> counterOffersList = new ArrayList<>();
        String query = "select * from counter_offers";

        try (
            Connection connection = new  DataBaseHelper().getConexion("mySQL");
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery()
        ) {
            while (result.next()) {
                counterOffersList.add(new CounterOffers(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("vom"),
                    result.getDouble("originalPrice"),
                    result.getDouble("counterOfferPrice"),
                    result.getDouble("quantity"))
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return counterOffersList;
    }
}
