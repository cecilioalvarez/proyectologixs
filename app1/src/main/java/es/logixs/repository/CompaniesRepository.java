package es.logixs.repository;

import es.logixs.domain.Companies;
import java.util.List;

public interface CompaniesRepository {
    Companies insert(Companies company);

    void delete(Companies company);

    Companies findOne(String objectid);

    List<Companies> findAll();
}
