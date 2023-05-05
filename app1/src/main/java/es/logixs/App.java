package es.logixs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 */
public final class App {
   
    private static final Logger milogger= LogManager.getLogger(App.class);
    public static void main(String[] args) {
        milogger.fatal("ha ocurrido un error fatal");
        System.out.println("Hello World!");
        milogger.error("ha ocurrido un error de verdad");
        milogger.warn("algo no va bien la variable no tiene el valor adecuado");
        milogger.info("pasamos por aqui esta es el codigo no se que");
        milogger.debug("ojo con este objeto que tal ocual");
        
      
        
    }
}
