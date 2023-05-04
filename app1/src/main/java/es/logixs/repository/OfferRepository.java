package es.logixs.repository;

import es.logixs.domain.Offer;

import java.util.List;

public interface OfferRepository {
    Offer insert(Offer offer);

    void delete(Offer offer);

    Offer findOne(int id);

    List<Offer> findAll();
}
