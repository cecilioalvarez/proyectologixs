package es.logixs.service;

import es.logixs.domain.CounterOffers;
import es.logixs.domain.Offer;
import es.logixs.repository.CounterOffersRepository;
import es.logixs.repository.OfferRepository;
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
    private OfferRepository offerRepository;
    @Mock
    private CounterOffersRepository counterOffersRepository;
    @InjectMocks
    private OffersService offersService;

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
    public void deleteOfferTest() {
        Offer offer = mock(Offer.class);
        offersService.deleteOffer(offer);
        verify(offerRepository, times(1)).delete(offer);
    }

    @Test
    public void deleteCounterOffer() {
        CounterOffers counterOffers = mock(CounterOffers.class);
        offersService.deleteCounterOffer(counterOffers);
        verify(counterOffersRepository, times(1)).delete(counterOffers);
    }
}
