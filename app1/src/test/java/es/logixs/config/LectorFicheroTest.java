package es.logixs.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import es.logixs.helper.LectorFichero;
import org.junit.jupiter.api.Test;

public class LectorFicheroTest {
    @Test
    void testLeerLineas() throws IOException {
       System.out.println("carpeta:" +System.getProperty("user.dir"));
        LectorFichero lector= new LectorFichero("cargadatos.sql");
        int lineas= lector.leerLineas().size();
        assertEquals(1,lineas);
    }
}
