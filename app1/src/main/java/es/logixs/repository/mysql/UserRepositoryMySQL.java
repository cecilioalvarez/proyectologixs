package es.logixs.repository.mysql;

import es.logixs.config.ConfiguradorSpring;
import es.logixs.domain.User;
import es.logixs.repository.UserRepository;
import es.logixs.repository.mysql.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserRepositoryMySQL implements UserRepository{

    ConfiguradorSpring cS = new ConfiguradorSpring();

    private final static String sqlInsert = "insert into user (objectid,name,lastName,email) values (?,?,?,?)";
    private final static String sqlDelete = "delete from user where objectid=?";
    private final static String sqlFindAll = "select * from user";
    private final static String sqlFindOne = "select * from user where objectid=?";

    @Override
    public User insert(User user) {
        cS.template().update(sqlInsert, user.getObjectid(),user.getName(), user.getLastName(),user.getEmail());
        return user;
    }

    @Override
    public void delete(User user) {
        cS.template().update(sqlDelete, user.getObjectid());
    }

    @Override
    public User findOne(String objectid) {
        return  cS.template().queryForObject(sqlFindOne, User.class, objectid);
    }

    @Override
    public List<User> findAll() {
        return cS.template().query(sqlFindAll, new UserMapper());
    }
}
