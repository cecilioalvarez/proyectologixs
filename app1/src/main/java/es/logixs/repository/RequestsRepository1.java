package es.logixs.repository;

import es.logixs.domain.Requests;

import java.util.List;

public interface RequestsRepository1 {

    Requests insert(Requests requests);
    Requests findOne(String id);
    List<Requests> findAll();
    void delete(String id);
}
