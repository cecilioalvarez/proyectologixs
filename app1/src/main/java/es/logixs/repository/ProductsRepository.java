package es.logixs.repository;

import es.logixs.domain.Products;

import java.util.List;

public interface ProductsRepository {

    Products insert(Products product);
    Products findOne(String id);
    List<Products> findAll();
    void delete(String id);
}
