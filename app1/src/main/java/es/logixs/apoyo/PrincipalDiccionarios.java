package es.logixs.apoyo;

import java.util.HashMap;

public class PrincipalDiccionarios {
 
    public static void main(String[] args) {
        

        HashMap<String,String> personas= new HashMap<String,String>();
        personas.put("pedro","perez");
        personas.put("ana","gomez");

        System.out.println(personas.get("pedro"));
        System.out.println(personas.get("ana"));
    }
}
