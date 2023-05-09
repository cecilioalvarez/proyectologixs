package es.logixs.repository.mysql.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.logixs.domain.Companies;

public class CompaniesMapper  implements RowMapper<Companies>{

    @Override
    public Companies mapRow(ResultSet rs, int rowNum) throws SQLException {
      
      return  new Companies(rs.getString("objectid"), rs.getString("code"), rs.getString("licenseId"),
                        rs.getString("name"), rs.getString("taxId"));
    }
    
}
