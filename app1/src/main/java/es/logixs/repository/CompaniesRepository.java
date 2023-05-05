package es.logixs.repository;


import java.util.List;

import es.logixs.domain.Companies;

public interface CompaniesRepository {

    Companies insert(Companies company);

    void delete(Companies company);
    List<Companies> findAll();

    Companies findOne(String objectid);

}
