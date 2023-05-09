package es.logixs.repository;

import es.logixs.config.CargadorConsultasSQL;
import es.logixs.config.DataBaseHelper;
import es.logixs.domain.CounterOffers;
import es.logixs.helper.LectorFichero;
import es.logixs.repository.mysql.CounterOffersRepositoryMySQL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CounterOffersRepositoryTest {
    private static CounterOffersRepository counterOffersRepository;

    @BeforeAll
    public static void init() {
        counterOffersRepository = new CounterOffersRepositoryMySQL();
    }

    @BeforeEach
    public void inicializar() throws IOException {
        LectorFichero lector = new LectorFichero("cargadatos_counter_offers.sql");
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper);
        cargador.cargarFichero();
    }

    @Test
    void should_insert() {
        CounterOffers counterOffers = new CounterOffers(
            "5",
            "name5",
            "vom5",
            2.0,
            4.0,
            10.0
        );

        CounterOffers counterOffersInserted = counterOffersRepository.insert(counterOffers);

        assertEquals(counterOffers, counterOffersInserted);
    }

    @Test
    void should_update() {
        CounterOffers counterOffers = new CounterOffers(
            "5",
            "name5",
            "vom5",
            2.0,
            4.0,
            5
        );

        CounterOffers counterOffersUpdated = counterOffersRepository.update(counterOffers);

        assertEquals(counterOffers, counterOffersUpdated);
    }

    @Test
    void should_delete() {
        CounterOffers counterOffers = new CounterOffers(
            "5",
            "name5",
            "vom5",
            2.0,
            4.0,
            5
        );

        counterOffersRepository.delete(counterOffers);
        CounterOffers counterOffersDeleted = counterOffersRepository.findOne("5");

        assertNull(counterOffersDeleted);
    }

    @Test
    void should_findOne() {
        CounterOffers counterOffersFound = counterOffersRepository.findOne("4");

        assertEquals("name4", counterOffersFound.getName());
    }
}
