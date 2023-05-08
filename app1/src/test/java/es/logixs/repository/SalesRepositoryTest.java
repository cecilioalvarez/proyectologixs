package es.logixs.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import es.logixs.helper.LectorFichero;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.logixs.config.CargadorConsultasSQL;
import es.logixs.config.DataBaseHelper;
import es.logixs.domain.Sales;
import es.logixs.repository.mysql.SalesRepositoryMySQL;

public class SalesRepositoryTest {

    public static SalesRepository repository;

    @BeforeAll
    public static void globalInit() {
        repository = new SalesRepositoryMySQL();
    }

    @BeforeEach
    public void init() throws IOException{
        LectorFichero lector = new LectorFichero("cargadatosales.sql");
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper);
        cargador.cargarFichero();
    }

    @Test
    public void deleteTest() {
        Sales sales = new Sales("0001","0001","0001","1A","1","1",true);
        repository.delete(sales);
        Sales deletesales = repository.findOne("0001");

        assertNull(deletesales);
    }

    @Test
    public void findAllTest() {
        List<Sales> list = repository.findAll();

        assertTrue(list.size()>5);
    }

    @Test
    public void findOneTest() {
        Sales sales = repository.findOne("0001");

        assertEquals("0001", sales.getId());
        assertEquals("0001", sales.getOwnerId());
    }

    @Test
    public void insertTest() {
        Sales sales = new Sales("0012","0012","0012","12A","12","12",true);
        Sales salesInserted = repository.insert(sales);

        assertEquals(sales, salesInserted);
    }

    @Test
    public void updateTest() {
        Sales sales = new Sales("012","00012","0012","12A","12","12",true);

        sales.setOwnerId("0015");
        sales.setCode("15A");

        Sales updatedSales = repository.update(sales);

        assertEquals(sales, updatedSales);
    }


}
