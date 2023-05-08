package es.logixs.repository.mysql;

import es.logixs.config.DataBaseHelper;
import es.logixs.domain.User;
import es.logixs.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryMySQL implements UserRepository{

    private static final Logger logger= LogManager.getLogger(UserRepositoryMySQL.class);

    private final static String sqlInsert = "insert into user (objectid,name,lastName,email) values (?,?,?,?)";
    private final static String sqlDelete = "delete from user where objectid=?";
    private final static String sqlFindAll = "select * from user";
    private final static String sqlFindOne = "select * from user where objectid=?";

    @Override
    public User insert(User user) {
        logger.info("Trying to insert User with objectid: {}", user.getObjectid());
        try (Connection connection = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement query = connection.prepareStatement(sqlInsert)) {
            query.setString(1, user.getObjectid());
            query.setString(2, user.getName());
            query.setString(3, user.getLastName());
            query.setString(4, user.getEmail());
            query.executeUpdate();
            logger.info("User inserted successfully with objectid: {}", user.getObjectid());
        } catch (SQLException e) {
            logger.error("Error inserting user with objectid: {}", user.getObjectid(), e);
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void delete(User user) {
        logger.info("Trying to delete User with objectid: {}", user.getObjectid());
        try (Connection connection = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement query = connection.prepareStatement(sqlDelete)) {
            query.setString(1, user.getObjectid());
            query.executeUpdate();
            logger.info("User deleted successfully with objectid: {}", user.getObjectid());
        } catch (SQLException e) {
            logger.error("Error deleting user with objectid: {}", user.getObjectid(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findOne(String objectid) {
        User user = null;
        logger.info("Trying to find User with objectid: {}", objectid);
        try (Connection conn = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement(sqlFindOne)) {
            stmt.setString(1, objectid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new User(rs.getString("objectid"), rs.getString("name"), rs.getString("lastName"), rs.getString("email"));
                    logger.info("User searched successfully with objectid: {}", user.getObjectid());
                }
            }
        } catch (SQLException e) {
            logger.error("Error finding user with objectid: {}", objectid, e);
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        logger.info("Trying to find all Users");
        try (Connection conn = new  DataBaseHelper().getConexion("mySQL");
             PreparedStatement stmt = conn.prepareStatement(sqlFindAll);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                list.add(new User(rs.getString("objectid"), rs.getString("name"), rs.getString("lastName"), rs.getString("email")));
            }
            logger.info("All Users found successfully");

        } catch (SQLException e) {
            logger.info("Error finding the users");
            throw new RuntimeException(e);
        }
        return list;
    }
}
