package es.logixs.repository.mysql.mappers;

import es.logixs.domain.Companies;
import es.logixs.domain.Requests;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestsMapper implements RowMapper<Requests>{

    @Override
    public Requests mapRow(ResultSet rs, int rowNum) throws SQLException {

      return new Requests(rs.getString("code"), rs.getString("offerId"), rs.getString("ownerId"), rs.getString("companyId"));
    }

}
