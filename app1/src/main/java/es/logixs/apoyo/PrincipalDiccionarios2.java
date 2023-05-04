package es.logixs.apoyo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PrincipalDiccionarios2 {
 
    public static void main(String[] args) {
        

      Properties propiedades= new Properties();
      System.out.println(System.getProperty("user.dir"));

      try {
        propiedades.load(new FileInputStream(new File("datos.properties")));
        System.out.println(propiedades.get("usuario"));
        System.out.println(propiedades.get("url"));
        System.out.println(propiedades.get("clave"));
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    
      
    
    }
}
