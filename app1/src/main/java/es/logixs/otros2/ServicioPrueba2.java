package es.logixs.otros2;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServicioPrueba2 {

    private static final Logger milogger= LogManager.getLogger(ServicioPrueba2.class);

    public List<String> getLista() {

        List<String> lista = List.of("hola", "que", "tal", "estas");
       
        milogger.info("ENTRAMOS EN EL METODO GETLISTA");
        milogger.warn("LA LISTA NO PUEDE ESTAR VACIA{}",lista);
        milogger.debug("EL TAMAÑO DE LA LISTA ES : {} LOS ELEMNTOS SON{}",lista.size(),lista);
        
        try {
            
           throw new RuntimeException("la lista no se puede modificar");
           
        } catch (Exception e) {
            
           
           milogger.error("SE HA PRODUCIDO UN EROR :", e);
        }
     
        milogger.info("ANTES DE RETORNAR LA LISTA");
        return lista;

    }
}
