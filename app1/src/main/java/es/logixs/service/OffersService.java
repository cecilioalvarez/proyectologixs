package es.logixs.service;

import es.logixs.domain.CounterOffers;
import es.logixs.domain.Offer;
import es.logixs.repository.CounterOffersRepository;
import es.logixs.repository.OfferRepository;

import java.util.List;

public class OffersService {

    private final OfferRepository offerRepository;
    private final CounterOffersRepository counterOffersRepository;


    public OffersService(OfferRepository offerRepository, CounterOffersRepository counterOffersRepository) {
        this.offerRepository = offerRepository;
        this.counterOffersRepository = counterOffersRepository;
    }

    public Offer insertOffer(Offer offer){
        return offerRepository.insert(offer);
    }

    public void deleteOffer(Offer offer){
        offerRepository.delete(offer);
    }

    public Offer findOneOffer(int objectId){
        return offerRepository.findOne(objectId);
    }

    public List<Offer> findAllOffers(){
        return offerRepository.findAll();
    }

    public CounterOffers insertCounterOffer(CounterOffers counterOffers){
        return counterOffersRepository.insert(counterOffers);
    }

    public void deleteCounterOffer(CounterOffers counterOffers){
        counterOffersRepository.delete(counterOffers);
    }

    public CounterOffers findOneCounterOffer(int objectId){
        return counterOffersRepository.findOne(objectId);
    }

    public List<CounterOffers> findAllCounterOffer(){
        return counterOffersRepository.findAll();
    }
}
