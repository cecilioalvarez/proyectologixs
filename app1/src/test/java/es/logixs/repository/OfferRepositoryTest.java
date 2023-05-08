package es.logixs.repository;

import es.logixs.config.CargadorConsultasSQL;
import es.logixs.config.DataBaseHelper;

import es.logixs.domain.Offer;
import es.logixs.helper.LectorFichero;
import es.logixs.repository.mysql.OfferRepositoryMySQL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class OfferRepositoryTest {

    private static OfferRepository repository;

    @BeforeAll
    public static void init() {
        repository = new OfferRepositoryMySQL();
    }

    @BeforeEach
    public void inicializar() throws IOException {

        LectorFichero lector = new LectorFichero("testOfferDomain.sql");
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper);
        cargador.cargarFichero();
    }

    @Test
    void insert() {
        Offer offer = new Offer(6, "123456789", "offer1", "description offer 1", "category1");
        Offer offerFinal = repository.insert(offer);
        assertEquals(offer, offerFinal);
    }

    @Test
    void delete() {
        Offer offer = new Offer(6, "123456789", "offer1", "description offer 1", "category1");
        repository.delete(offer);
        Offer offerDeleted = repository.findOne(6);
        assertNull(offerDeleted);

    }

    @Test
    void findOne() {
        Offer offer = repository.findOne(2);
        assertEquals(2, offer.getId());
        assertEquals("offer2", offer.getName());
        assertEquals("1231242", offer.getCode());
    }

    @Test
    void findAll() {
        List<Offer> lista = repository.findAll();
        assertTrue(lista.size()>=5);
    }
}
