package es.logixs.repository;

import es.logixs.config.CargadorConsultasSQL;
import es.logixs.config.DataBaseHelper;
import es.logixs.domain.Requests;
import es.logixs.helper.LectorFichero;
import es.logixs.repository.mysql.RequestRepositoryMySQL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RequestsRepositoryTest {

    private static RequestsRepository repository;

    @BeforeAll
    public static void init() {
        repository = new RequestRepositoryMySQL();
    }

    @BeforeEach
    public void inicializar() throws IOException {

        LectorFichero lector = new LectorFichero("testRequestsDomain.sql");
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper);
        cargador.cargarFichero();
    }

    @Test
    void insert() {
        Requests requests = new Requests("123456789", "offer6", "owner6", "company6");
        Requests requestsFinal = repository.insert(requests);
        assertEquals(requests, requestsFinal);
    }

    @Test
    void delete() {
        Requests request = new Requests("123456789", "offer6", "owner6", "company6");
        repository.delete(request.getId());
        Requests requestDeleted = repository.findOne("6");
        assertNull(requestDeleted);

    }

    @Test
    void findOne() {
        Requests request = repository.findOne("2");
        assertEquals("2", request.getId());
        assertEquals("offer2", request.getOfferId());
        assertEquals("1231242", request.getCode());
    }

    @Test
    void findAll() {
        List<Requests> lista = repository.findAll();
        assertTrue(lista.size()>=5);
    }
}
