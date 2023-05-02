package es.logixs.repository;

import es.logixs.domain.Requests;

import java.util.List;

public interface RequestsRepository {

    Requests insert(Requests requests);
    Requests findOne(String id);
    List<Requests> findAll();
    void delete(String id);
}
