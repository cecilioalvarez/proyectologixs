package es.logixs.repository.mysql.mappers;

import es.logixs.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        return  new User(rs.getString("objectid"), rs.getString("name"), rs.getString("lastname"),
            rs.getString("email"));
    }
}
