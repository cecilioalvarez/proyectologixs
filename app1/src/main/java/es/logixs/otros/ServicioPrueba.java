package es.logixs.otros;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServicioPrueba {

    private static final Logger milogger= LogManager.getLogger(ServicioPrueba.class);

    public List<String> getLista() {

        List<String> lista = List.of("hola", "que", "tal", "estas");
       
        milogger.info("entramos en el metodo getlista");
        milogger.warn("la lista no puede estar vacia{}",lista);
        milogger.debug("el tamaño de la lista es : {} los elementos son {}",lista.size(),lista);
    
        try {
            
           throw new RuntimeException("la lista no se puede modificar");
           
        } catch (Exception e) {
            
           
           milogger.error("se ha producido un error :", e);
        }
     
        milogger.info("antes de retornar la lista");
        return lista;

    }
}
