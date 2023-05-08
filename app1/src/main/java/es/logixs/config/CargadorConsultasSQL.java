package es.logixs.config;

import java.io.IOException;
import java.util.List;

import es.logixs.helper.LectorFichero;

public class CargadorConsultasSQL {
    
  
    private LectorFichero  lector;
    private DataBaseHelper dataBaseHelper;
    public CargadorConsultasSQL(LectorFichero lector, DataBaseHelper dataBaseHelper) {
        this.lector=lector;
        this.dataBaseHelper=dataBaseHelper;
    }

    //lo que hace es verifica que se han insertado las lineas
    // que se leyeron con el lector en la base de datos
    public int cargarFichero() throws IOException {

     List<String> lineas= lector.leerLineas();

     for (String linea: lineas) {

        dataBaseHelper.executarConsulta(linea);

     }
     return lineas.size();
    }



  
}
