package es.logixs.service;

import es.logixs.domain.CounterOffers;
import es.logixs.domain.Offer;
import es.logixs.repository.CounterOffersRepository;
import es.logixs.repository.OfferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OffersServiceTest {

    @Mock
    private static OfferRepository offerRepository;

    @Mock
    private static CounterOffersRepository counterOffersRepository;

    @InjectMocks
    private static OffersService offersService;

    @Test
    public void findAllCounterOffersTest() {
        CounterOffers counterOffer1 = mock(CounterOffers.class);
        CounterOffers counterOffer2 = mock(CounterOffers.class);
        List<CounterOffers> listCounterOffers = Arrays.asList(counterOffer1, counterOffer2);

        when(counterOffersRepository.findAll()).thenReturn(listCounterOffers);

        List<CounterOffers> listCounterOffersResult = offersService.findAllCounterOffer();

        verify(counterOffersRepository, times(1)).findAll();
        assertEquals(listCounterOffers, listCounterOffersResult);
    }
    @Test
    public void findAllOffersTest() {
        Offer offer1 = mock(Offer.class);
        Offer offer2 = mock(Offer.class);

        List<Offer> listOffer = Arrays.asList(offer1, offer2);

        when(offerRepository.findAll()).thenReturn(listOffer);

        List<Offer> listOfferResult = offersService.findAllOffers();

        verify(offerRepository, times(1)).findAll();
        assertEquals(listOffer, listOfferResult);
    }

    @Test
    public void insertCounterOfferTest() {
        CounterOffers counterOffer = mock(CounterOffers.class);
        when(counterOffersRepository.insert(counterOffer)).thenReturn(counterOffer);

        CounterOffers insertedCounterOffer = offersService.insertCounterOffer(counterOffer);

        verify(counterOffersRepository, times(1)).insert(counterOffer);
        assertEquals(counterOffer, insertedCounterOffer);
    }

    @Test
    public void insertOfferTest() {
        Offer offer = mock(Offer.class);
        when(offerRepository.insert(offer)).thenReturn(offer);

        Offer insertedOffer = offersService.insertOffer(offer);

        verify(offerRepository, times(1)).insert(offer);
        assertEquals(offer, insertedOffer);
    }

    @Test
    public void findOneCounterOffer() {
        int id = 2;

        CounterOffers counterOffer = mock(CounterOffers.class);

        when(counterOffersRepository.findOne(id)).thenReturn(counterOffer);
        CounterOffers counterOfferResult = offersService.findOneCounterOffer(id);

        verify(counterOffersRepository, times(1)).findOne(id);
        assertEquals(counterOffer, counterOfferResult);
    }

    @Test
    public void findOneOffer() {
        int id = 2;

        Offer offer = mock(Offer.class);

        when(offerRepository.findOne(id)).thenReturn(offer);
        Offer offerResult = offersService.findOneOffer(id);

        verify(offerRepository, times(1)).findOne(id);
        assertEquals(offer, offerResult);
    }

}
