package es.logixs.config;

import java.sql.*;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseHelper {

    @Autowired
    private DataSource dataSource;

    public  Connection getConexion(String tipoBaseDatos) throws SQLException {

       return dataSource.getConnection();

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
