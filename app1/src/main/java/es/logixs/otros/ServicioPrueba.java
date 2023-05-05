package es.logixs.otros;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServicioPrueba {

    private static final Logger milogger= LogManager.getLogger(ServicioPrueba.class);

    public List<String> getLista() {



        List<String> lista = List.of("hola", "que", "tal", "estas");
       
       
        try {
            lista.add("nueva");
            if (lista.size()<4)
{
                throw new IOException("todo peto");
            }
        } catch (IOException e) {
            
            milogger.error("se ha producido un error",e);
        }
     

        return lista;

    }
}
