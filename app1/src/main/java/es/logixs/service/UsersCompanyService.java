package es.logixs.service;

import es.logixs.domain.User;
import es.logixs.domain.Companies;
import es.logixs.repository.mysql.CompaniesRepositoryMySQL;
import es.logixs.repository.mysql.UserRepositoryMySQL;

import java.util.List;

public class UsersCompanyService {

    private UserRepositoryMySQL repositorioUserMySQL;
    private CompaniesRepositoryMySQL repositorioCompaniesMySQL;

    public UsersCompanyService(UserRepositoryMySQL repositorioUserMySQL, CompaniesRepositoryMySQL repositorioCompaniesMySQL) {
        this.repositorioUserMySQL = repositorioUserMySQL;
        this.repositorioCompaniesMySQL = repositorioCompaniesMySQL;
    }

    public void deleteUser(User user) {
        repositorioUserMySQL.delete(user);
    }

    public void deleteCompanies(Companies company) {
        repositorioCompaniesMySQL.delete(company);
    }


    public Companies insertCompanies(Companies company) {
        return repositorioCompaniesMySQL.insert(company);
    }

    public User insertUser(User user) {
        return repositorioUserMySQL.insert(user);
    }

    public List<Companies> findAllCompanies() {
        return repositorioCompaniesMySQL.findAll();
    }

    public List<User> findAllUsers() {
        return repositorioUserMySQL.findAll();
    }

    public Companies findOneCompanies(String objectid) {
        return repositorioCompaniesMySQL.findOne(objectid);
    }

    public User findOneUser(String objectid) {
        return repositorioUserMySQL.findOne(objectid);
    }




}
