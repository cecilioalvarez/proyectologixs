package es.logixs.repository.mysql;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import es.logixs.config.DataBaseHelper;

import es.logixs.domain.Sales;
import es.logixs.repository.SalesRepository;
import es.logixs.repository.mysql.mappers.SalesMapper;

@Component
public class SalesRepositoryMySQL implements SalesRepository {

    private final static String sqlUpdate = "update  sales set ownerId=?, clientId=?, code=?, offerId=?, counterOfferId=?, isCounterOffer=? where id=?";

    private final static String sqlInsert = "insert into sales (id,ownerId,clientId,code,offerId,counterOfferId,isCounterOffer) values (?,?,?,?,?,?,?)";

    private final static String sqlDelete = "delete from sales where id=?";

    private final static String sqlFindAll = "select * from sales";

    private final static String sqlFindOne = "select * from sales where id=?";

    @Autowired
    private JdbcTemplate template;

    @Override
    public Sales insert(Sales sales) {
        template.update(sqlInsert,sales.getId(),sales.getOwnerId(),sales.getClientId(),sales.getCode(),sales.getOfferId(),sales.getCounterOfferId(),sales.isCounterOffer());
        return sales;
    }

    @Override
    public void delete(Sales sales) {
        template.update(sqlDelete,sales.getId());
    }

    @Override
    public List<Sales> findAll() {
        return template.query(sqlFindAll, new SalesMapper());
    }

    @Override
    public Sales findOne(String id) {
        return template.queryForObject(sqlFindOne,Sales.class,id);
    }

    @Override
    public Sales update(Sales sales) {
        template.update(sqlUpdate,sales.getId(),sales.getOwnerId(),sales.getClientId(),sales.getCode(),sales.getOfferId(),sales.getCounterOfferId(),sales.isCounterOffer());
        return sales;
    }

}