package es.logixs.repository.mysql;

import es.logixs.domain.Offer;
import es.logixs.repository.OfferRepository;
import es.logixs.repository.mysql.mappers.OfferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OfferRepositoryMySQL implements OfferRepository {

    private final static String sqlInsert = "insert into offer (id,code,name,description,category) values (?,?,?,?,?)";
    private final static String sqlDelete = "delete from offer where id=?";
    private final static String sqlFindAll = "select * from offer";
    private final static String sqlFindOne = "select * from offer where id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Offer insert(Offer offer) {

        jdbcTemplate.update(sqlInsert, offer.getId(), offer.getCode(), offer.getName(), offer.getDescription(), offer.getCategory());
        return offer;
    }

    @Override
    public void delete(Offer offer) {
        jdbcTemplate.update(sqlDelete, offer.getId());
    }

    @Override
    public List<Offer> findAll() {
        return jdbcTemplate.query(sqlFindAll, new OfferMapper());
    }

    @Override
    public Offer findOne(int id) {
        return jdbcTemplate.queryForObject(sqlFindOne, new OfferMapper(), id);
    }
}
