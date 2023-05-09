package es.logixs.repository.mysql.mappers;

import es.logixs.domain.Companies;
import es.logixs.domain.User;
import es.logixs.repository.CompaniesRepository;
import es.logixs.repository.mysql.CompaniesRepositoryMySQL;
import es.logixs.repository.mysql.UserRepositoryMySQL;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {
    public static void main(String[] args) {
        UserRepositoryMySQL urep = new UserRepositoryMySQL();

        User u1 = new User("adfa","Kil","Lik","asdf@gmail.com");

        urep.insert(u1);

    }
}
