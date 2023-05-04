package es.logixs.repository;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import es.logixs.config.DataBaseHelper;

import es.logixs.domain.Sales;

public class SalesRepositoryMySQL implements SalesRepository {

    private final static String sqlUpdate = "update  sales set ownerId=?, clientId=?, code=?, offerId=?, counterOfferId=?, isCounterOffer=? where id=?";

    private final static String sqlInsert = "insert into sales (id,ownerId,clientId,code,offerId,counterOfferId,isCounterOffer) values (?,?,?,?,?,?,?)";

    private final static String sqlDelete = "delete from sales where id=?";

    private final static String sqlFindAll = "select * from sales";

    private final static String sqlFindOne = "select * from sales where id=?";

    @Override

    public void delete(Sales sales) {

        try (Connection conexion = DataBaseHelper.getConexion("mySQL");

                PreparedStatement sentencia = conexion.prepareStatement(sqlDelete);) {

            sentencia.setString(1, sales.getId());

            sentencia.executeUpdate();

        } catch (SQLException e) {

            System.out.println("ha ocurrido un error");

            throw new RuntimeException(e);

        }

    }

    @Override

    public List<Sales> findAll() {

        List<Sales> list = new ArrayList<Sales>();

        try (Connection conn = DataBaseHelper.getConexion("mySQL");

                PreparedStatement stmt = conn.prepareStatement(sqlFindAll);

                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                list.add(new Sales(rs.getString("id"), rs.getString("ownerId"), rs.getString("clientId"),

                        rs.getString("code"), rs.getString("offerId"), rs.getString("counterOfferId"),

                        rs.getBoolean("isCounterOffer")));

            }

        } catch (SQLException e) {

            System.out.println("ha ocurrido un error");

            throw new RuntimeException(e);

        }

        return list;
    }

    @Override

    public Sales findOne(String id) {

        Sales sales = null;

        try (Connection conn = DataBaseHelper.getConexion("mySQL");

                PreparedStatement stmt = conn.prepareStatement(sqlFindOne);) {

            stmt.setString(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next() != false)

                    sales = new Sales(rs.getString("id"), rs.getString("ownerId"), rs.getString("clientId"),

                            rs.getString("code"), rs.getString("offerId"), rs.getString("counterOfferId"),

                            rs.getBoolean("isCounterOffer"));

            }

        } catch (SQLException e) {

            System.out.println("ha ocurrido un error");

            throw new RuntimeException(e);

        }

        return sales;
    }

    @Override

    public Sales insert(Sales sales) {

        try (Connection conexion = DataBaseHelper.getConexion("mySQL");

                PreparedStatement sentencia = conexion.prepareStatement(sqlInsert);) {

            sentencia.setString(1, sales.getId());

            sentencia.setString(2, sales.getOwnerId());

            sentencia.setString(3, sales.getClientId());

            sentencia.setString(4, sales.getCode());

            sentencia.setString(5, sales.getOfferId());

            sentencia.setString(6, sales.getCounterOfferId());

            sentencia.setBoolean(7, sales.isCounterOffer());

            sentencia.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            throw new RuntimeException(e);

        }

        return sales;

    }

    @Override

    public Sales update(Sales sales) {

        try (Connection conexion = DataBaseHelper.getConexion("mySQL");

                PreparedStatement sentencia = conexion.prepareStatement(sqlUpdate);) {

            sentencia.setString(1, sales.getOwnerId());

            sentencia.setString(2, sales.getClientId());

            sentencia.setString(3, sales.getCode());

            sentencia.setString(4, sales.getOfferId());

            sentencia.setString(5, sales.getCounterOfferId());

            sentencia.setBoolean(6, sales.isCounterOffer());

            sentencia.setString(7, sales.getId());

            sentencia.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            throw new RuntimeException(e);

        }

        return sales;

    }

}
