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
        return null;
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
