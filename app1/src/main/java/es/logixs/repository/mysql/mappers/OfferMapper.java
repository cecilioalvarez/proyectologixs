package es.logixs.repository.mysql.mappers;

import es.logixs.domain.Offer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferMapper implements RowMapper<Offer>{

    @Override
    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {

      return  new Offer(rs.getInt("objectid"), rs.getString("code"), rs.getString("name"),
                        rs.getString("description"), rs.getString("category"));
    }

}
