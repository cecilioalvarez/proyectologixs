package es.logixs.repository;

import es.logixs.domain.CounterOffers;

import java.util.List;

public interface CounterOffersRepository {
    CounterOffers insert(CounterOffers counterOffer);

    CounterOffers update(CounterOffers counterOffer);

    void delete(CounterOffers counterOffer);

    CounterOffers findOne(int id);

    List<CounterOffers> findAll();
}
