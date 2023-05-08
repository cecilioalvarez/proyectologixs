package es.logixs.service;

import es.logixs.domain.User;
import es.logixs.domain.Companies;
import es.logixs.repository.CompaniesRepository;
import es.logixs.repository.UserRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class UsersCompanyService {

 
    private UserRepository repositorioUserMySQL;

    private CompaniesRepository repositorioCompaniesMySQL;


    public UsersCompanyService(UserRepository repoUsers, CompaniesRepository repoCompanies) {
        this.repositorioUserMySQL = repoUsers;
        this.repositorioCompaniesMySQL = repoCompanies;
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
