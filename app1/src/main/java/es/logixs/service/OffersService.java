package es.logixs.service;

import es.logixs.domain.Offer;
import es.logixs.repository.CounterOffersRepository;
import es.logixs.repository.OfferRepository;

public class OffersService {

    private final OfferRepository offerRepository;
    private final CounterOffersRepository counterOffersRepository;


    public OffersService(OfferRepository offerRepository, CounterOffersRepository counterOffersRepository) {
        this.offerRepository = offerRepository;
        this.counterOffersRepository = counterOffersRepository;
    }

    public Offer ejemplo(Offer Offer) {
        return new Offer();
    }
}
