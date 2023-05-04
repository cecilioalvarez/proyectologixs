package es.logixs.service;

import es.logixs.repository.CounterOffersRepository;
import es.logixs.repository.OfferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class OffersServiceTest {

    @Mock
    private static OfferRepository offerRepository;

    @Mock
    private static CounterOffersRepository counterOffersRepository;

    @InjectMocks
    private static OffersService offersService;

    @Test
    public void ejemploTest() {

    }
}
