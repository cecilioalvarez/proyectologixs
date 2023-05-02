package es.logixs.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LectorFichero {

    private String fichero;

    public String getFichero() {
        return fichero;
    }

    public void setFichero(String fichero) {
        this.fichero = fichero;
    }

    public LectorFichero(String fichero) {
        this.fichero = fichero;
    }
    // es un lector generico
    public List<String> leerLineas() throws IOException {

        Path path = Paths.get(fichero);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
      
    }
}
