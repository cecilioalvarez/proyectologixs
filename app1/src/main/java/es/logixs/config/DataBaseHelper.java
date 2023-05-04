package es.logixs.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DataBaseHelper {


    public  Connection getConexion(String tipoBaseDatos) throws SQLException {

        Properties propiedades= new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream("database.properties");

        try {
            propiedades.load(is);
        } catch (IOException e) {
          
            e.printStackTrace();
        }

        if (tipoBaseDatos.equals("mySQL")) {
            return DriverManager.getConnection(propiedades.getProperty("url"),propiedades.getProperty("user"), propiedades.getProperty("password"));

        } else {

            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        }

    }

    public void executarConsulta(String sql) {




        try (Connection conexion =getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sql);) {
            sentencia.executeUpdate();
        } catch (Exception e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        }
    }


}
