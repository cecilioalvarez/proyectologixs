package es.logixs.repository.mysql.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import es.logixs.domain.Sales;

public class SalesMapper implements RowMapper<Sales>{

    @Override
    public Sales mapRow(ResultSet rs, int rowNum) throws SQLException {
      
      return new Sales(rs.getString("id"),rs.getString("ownerId"),rs.getString("clientId"), rs.getString("code"),rs.getString("offerId"), rs.getString("counterOfferId"),rs.getBoolean("isCounterOffer"));
    }
}