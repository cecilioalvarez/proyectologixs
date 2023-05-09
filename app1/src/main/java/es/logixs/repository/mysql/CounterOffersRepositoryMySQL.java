package es.logixs.repository.mysql;

import es.logixs.domain.CounterOffers;
import es.logixs.repository.CounterOffersRepository;
import es.logixs.repository.mysql.mappers.CounterOffersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CounterOffersRepositoryMySQL implements CounterOffersRepository {
    private final static String sqlInsert = "insert into counter_offers (object_id,name,vom,originalPrice,counterOfferPrice,quantity) values(?,?,?,?,?,?)";
    private final static String sqlUpdate = "update counter_offers set name=? ,vom=? ,originalPrice=? ,counterOfferPrice=? ,quantity=? where object_id=?";
    private final static String sqlDelete = "delete from products where object_id=?";
    private final static String sqlFindAll = "select * from products;";
    private final static String sqlFindOne = "select * from products  where object_id=?;";
    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public CounterOffers insert(CounterOffers counterOffer) {
        plantilla.update(
            sqlInsert,
            counterOffer.getObjectId(),
            counterOffer.getName(),
            counterOffer.getVom(),
            counterOffer.getOriginalPrice(),
            counterOffer.getCounterOfferPrice(),
            counterOffer.getQuantity()
        );
        return counterOffer;
    }

    @Override
    public CounterOffers update(CounterOffers counterOffer) {
        plantilla.update(
            sqlUpdate,
            counterOffer.getObjectId(),
            counterOffer.getName(),
            counterOffer.getVom(),
            counterOffer.getOriginalPrice(),
            counterOffer.getCounterOfferPrice(),
            counterOffer.getQuantity()
        );
        return counterOffer;
    }

    @Override
    public void delete(CounterOffers counterOffer) {
        plantilla.update(sqlDelete, counterOffer.getObjectId());
    }

    @Override
    public CounterOffers findOne(String objectId) {
        return plantilla.queryForObject(sqlFindOne, CounterOffers.class, objectId);
    }

    @Override
    public List<CounterOffers> findAll() {
        return plantilla.query(sqlFindAll, new CounterOffersMapper());
    }
}
