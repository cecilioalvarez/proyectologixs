package es.logixs.repository;

import es.logixs.config.DataBaseHelper;
import es.logixs.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryMySQL implements UserRepository{

    @Override
    public User insert(User user) {
        String sql = "insert into user (objectid,name,lastName,email) values (?,?,?,?)";

        try (Connection connection = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, user.getObjectid());
            query.setString(2, user.getName());
            query.setString(3, user.getLastName());
            query.setString(4, user.getEmail());
            query.executeUpdate();
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void delete(User user) {
        String sql = "delete from user where objectid=?";

        try (Connection connection = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement query = connection.prepareStatement(sql)) {
            query.setString(1, user.getObjectid());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Something went wrong.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findOne(String objectid) {
        User user = null;

        try (Connection conn = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement("select * from user where objectid=?")) {
            stmt.setString(1, objectid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next())
                    user = new User(rs.getString("objectid"), rs.getString("name"), rs.getString("lastName"), rs.getString("email"));

            }

        } catch (

            SQLException e) {
            System.out.println("Something went wrong.");
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        try (Connection conn = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement("select * from user");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                list.add(new User(rs.getString("objectid"), rs.getString("name"), rs.getString("lastName"), rs.getString("email")));
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong.");
            throw new RuntimeException(e);
        }
        return list;
    }
}
