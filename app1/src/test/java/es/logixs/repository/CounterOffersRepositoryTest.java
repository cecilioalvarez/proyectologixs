package es.logixs.repository;

import es.logixs.config.CargadorConsultasSQL;
import es.logixs.config.DataBaseHelper;
import es.logixs.config.LectorFichero;
import es.logixs.domain.CounterOffers;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterOffersRepositoryTest {

    @Test
    void should_do_insert() throws IOException {
        CounterOffersRepository counterOffersRepository = new CounterOffersRepositoryMySQL();
        LectorFichero lector = new LectorFichero("cargadatos_counter_offers.sql");
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper);
        cargador.cargarFichero();

        CounterOffers counterOffers= new CounterOffers(5, "name5", "vom5",2.0,4.0,10.0);

        CounterOffers counterOffersInserted = counterOffersRepository.insert(counterOffers);

        assertEquals(counterOffers, counterOffersInserted);
    }

    @Test
    void should_do_update() throws IOException {
        CounterOffersRepository counterOffersRepository = new CounterOffersRepositoryMySQL();
        LectorFichero lector = new LectorFichero("cargadatos_counter_offers.sql");
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper);
        cargador.cargarFichero();

        CounterOffers counterOffers= new CounterOffers(5, "name5", "vom5",2.0,4.0,5);

        CounterOffers counterOffersUpdated = counterOffersRepository.update(counterOffers);

        assertEquals(counterOffers, counterOffersUpdated);
    }
}
