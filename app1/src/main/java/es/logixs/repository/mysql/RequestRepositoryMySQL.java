package es.logixs.repository.mysql;

import es.logixs.config.ConfiguradorSpring;
import es.logixs.domain.Companies;
import es.logixs.domain.Requests;
import es.logixs.main.App;
import es.logixs.repository.RequestsRepository;
import es.logixs.repository.mysql.mappers.CompaniesMapper;
import es.logixs.repository.mysql.mappers.RequestsMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class RequestRepositoryMySQL implements RequestsRepository {
    private final static String sqlInsert = "insert into Requests (code, offerId, ownerId, companyId) values (?,?,?,?);";
    private final static String sqlDelete = "delete from Requests where id=?";
    private final static String sqlFindAll = "select * from Requests;";
    private final static String sqlFindOne = "select * from Requests where id=?;";
    private static final Logger myLogger= LogManager.getLogger(App.class);

    @Autowired
    private ConfiguradorSpring cs;

    @Override
    public Requests insert(Requests requests) {
        cs.template().update(sqlInsert, requests.getCode(), requests.getOfferId(), requests.getOwnerId(), requests.getCompanyId());
        return requests;
    }

    @Override
    public Requests findOne(String id) {
        return  cs.template().queryForObject(sqlFindOne, Requests.class, id);
    }

    @Override
    public List<Requests> findAll() {
        return cs.template().query(sqlFindAll, new RequestsMapper());
    }

    @Override
    public void delete(String id) {
        cs.template().update(sqlDelete, id);
    }
}
