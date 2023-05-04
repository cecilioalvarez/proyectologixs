package es.logixs.repository;

import es.logixs.config.CargadorConsultasSQL;
import es.logixs.config.DataBaseHelper;
import es.logixs.config.LectorFichero;
import es.logixs.domain.User;
import es.logixs.repository.mysql.UserRepositoryMySQL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class UserRepositoryTest {

    private static UserRepositoryMySQL repository;

    @BeforeAll
    public static void init() {
        repository = new UserRepositoryMySQL();
    }

    @BeforeEach
    public void inicializar() throws IOException {

        LectorFichero lector = new LectorFichero("loadUsers.sql");
        DataBaseHelper dataBaseHelper = new DataBaseHelper();
        CargadorConsultasSQL cargador = new CargadorConsultasSQL(lector, dataBaseHelper);
        cargador.cargarFichero();
    }

    @Test
    void insert() {
        User user = new User("5A", "Ana", "Sanchez", "ana@mail.com");
        User userFinal = repository.insert(user);
        assertEquals(user, userFinal);
    }

    @Test
    void delete() {
        User user = new User("5A", "Ana", "Sanchez", "ana@mail.com");
        repository.delete(user);
        User userDeleted = repository.findOne("5A");
        assertNull(userDeleted);

    }

    @Test
    void findOne() {
        User user = repository.findOne("2A");
        assertEquals("2A", user.getObjectid());
        assertEquals("Pedro", user.getName());
        assertEquals("Sanchez", user.getLastName());
        assertEquals("pedro@mail.com", user.getEmail());
    }

    @Test
    void findAll() {
        List<User> lista = repository.findAll();
        assertTrue(lista.size()>=4);
    }
}
