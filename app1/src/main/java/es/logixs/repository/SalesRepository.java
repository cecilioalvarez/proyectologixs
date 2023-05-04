package es.logixs.repository;

import java.util.List;

import es.logixs.domain.Sales;

public interface SalesRepository {

    Sales insert(Sales sales);
    Sales update(Sales sales);
    Sales findOne(String id);
    List<Sales> findAll();
    void delete(Sales sales);

}

