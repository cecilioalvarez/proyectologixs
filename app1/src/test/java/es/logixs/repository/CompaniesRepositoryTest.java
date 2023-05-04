package es.logixs.repository;

import es.logixs.config.CargadorConsultasSQL;
import es.logixs.config.DataBaseHelper;
import es.logixs.config.LectorFichero;
import es.logixs.domain.Companies;
import es.logixs.repository.mysql.CompaniesRepositoryMySQL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CompaniesRepositoryTest {

    private static CompaniesRepositoryMySQL companiesRepository;

    @BeforeAll
    public static void init() {
        companiesRepository = new CompaniesRepositoryMySQL();
    }

    @BeforeEach
    public void inicializar() throws IOException {

        LectorFichero lector = new LectorFichero("cargardatoscompanies.sql");
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper);
        cargador.cargarFichero();
    }
    @Test
    void findOne() {
        Companies companyFinal;
        companyFinal = companiesRepository.findOne("1A");
        assertEquals("PWC", companyFinal.getName());
    }

    @Test
    void findAll() {
        List<Companies> lista = companiesRepository.findAll();
        assertTrue(lista.size()>=4);
    }
    @Test
    void insert() {
        Companies company = new Companies("6A", "32234", "ADF2323SD", "PWC DTS", "adsf23");
        Companies companyFinal = companiesRepository.insert(company);
        assertEquals(company, companyFinal);
    }

    @Test
    void delete() {
        Companies company = new Companies("6A", "32234", "ADF2323SD", "PWC DTS", "adsf23");
        companiesRepository.delete(company);
        Companies companyDeleted = companiesRepository.findOne("6A");
        assertNull(companyDeleted);

    }

}

