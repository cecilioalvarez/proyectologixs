package es.logixs.config;

import java.sql.*;

public class DataBaseHelper {


    public static Connection getConexion(String tipoBaseDatos) throws SQLException {

        if (tipoBaseDatos.equals("mySQL")) {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/logixs", "root", "");

        } else {

            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        }

    }

    public void executarConsulta(String sql) {




        try (Connection conexion =getConexion("mySQL");
             PreparedStatement sentencia = conexion.prepareStatement(sql);) {
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ha ocurrido un error");
            System.out.println(e.getMessage());
        }
    }


}
