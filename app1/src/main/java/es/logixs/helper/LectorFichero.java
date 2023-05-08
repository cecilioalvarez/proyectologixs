package es.logixs.helper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
        List<String> lineas = new ArrayList<String>();

        InputStream is = getClass().getClassLoader().getResourceAsStream(fichero);
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedReader reader = new BufferedReader(new InputStreamReader(bis, StandardCharsets.UTF_8));

        String linea = reader.readLine(); // leer la primera línea

        while (linea != null) {
            if (!linea.isEmpty()) { // verificar si la línea no está vacía
                lineas.add(linea);
            }
            linea = reader.readLine();
        }

        return lineas;
    }

}
