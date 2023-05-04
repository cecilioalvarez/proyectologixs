package es.logixs.repository;

import es.logixs.config.CargadorConsultasSQL;
import es.logixs.config.DataBaseHelper;
import es.logixs.config.LectorFichero;
import es.logixs.domain.Products;
import es.logixs.repository.mysql.ProductsRepositoryMySQL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ProductsRepositoryTest {

    private static ProductsRepository repository;

    @BeforeAll
    public static void init() {
        repository = new ProductsRepositoryMySQL();
    }

    @BeforeEach
    public void inicializar() throws IOException {

        LectorFichero lector = new LectorFichero("testProductsDomain.sql");
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper);
        cargador.cargarFichero();
    }

    @Test
    void insert() {
        Products product = new Products("7", "23", "123456789", "company1", "scientificName1", "product1", "category1", "ES", "quality1", "description1");
        Products productFinal = repository.insert(product);
        assertEquals(product, productFinal);
    }

    @Test
    void delete() {
        repository.delete("3");
        Products productDeleted = repository.findOne("3");
        assertNull(productDeleted);

    }

    @Test
    void findOne() {
        Products product = repository.findOne("2");
        assertEquals("2", product.getId());
        assertEquals("laptop", product.getName());
        assertEquals("1231241", product.getCode());
    }

    @Test
    void findAll() {
        List<Products> lista = repository.findAll();
        assertTrue(lista.size()>=5);
    }
}
