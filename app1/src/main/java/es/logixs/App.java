package es.logixs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.logixs.otros.ServicioPrueba;

/**
 * Hello world!
 */
public final class App {
   
    private static final Logger milogger= LogManager.getLogger(App.class);
    public static void main(String[] args) {
        milogger.info("pasamos por main");
        ServicioPrueba servicio= new ServicioPrueba();
       
        List<String> lista=servicio.getLista();

        System.out.println("Hello World!");
        milogger.info("finalizamos  main");
       
        
      
        
    }
}
