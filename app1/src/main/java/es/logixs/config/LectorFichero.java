package es.logixs.config;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        List<String> lineas= new ArrayList<String>();
      
      
        InputStream is =getClass().getClassLoader().getResourceAsStream("cargadatos.sql");
        BufferedInputStream bis= new BufferedInputStream(is);
        BufferedReader reader = new BufferedReader(
        new InputStreamReader(bis, StandardCharsets.UTF_8));
        
        String linea= reader.readLine();
     
        while (linea != null) {

            linea=reader.readLine();
            lineas.add(linea);
            
        }
       
        return lineas;
      
    }
}
