package es.logixs.repository.mysql;

import es.logixs.domain.Companies;
import es.logixs.repository.CompaniesRepository;
import es.logixs.repository.mysql.mappers.CompaniesMapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CompaniesRepositoryMySQL implements CompaniesRepository {

    private final static String sqlInsert = "insert into companies (objectid,code,licenseId,name,taxId) values (?,?,?,?,?)";
    private final static String sqlFindAll = "select * from companies";
    private final static String sqlDelete = "delete from companies where objectid=?";
    private final static String sqlFindOne = "select * from companies where objectid=?";
  
    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public Companies insert(Companies company) {   
        plantilla.update(sqlInsert, company.getObjectid(),company.getCode(), company.getLicenseId(),company.getName(), company.getTaxId());
        return company;
    }
    @Override
    public void delete(Companies company) {
        plantilla.update(sqlDelete, company.getObjectid());
    }

    @Override
    public List<Companies> findAll() {
        return plantilla.query(sqlFindAll, new CompaniesMapper());
    }
    
    @Override
    public Companies findOne(String objectid) {    
       return  plantilla.queryForObject(sqlFindOne, Companies.class, objectid);
    }

}
