package es.logixs;

import es.logixs.domain.Companies;
import es.logixs.repository.CompaniesRepository;
import es.logixs.repository.UserRepository;
import es.logixs.repository.mysql.CompaniesRepositoryMySQL;
import es.logixs.repository.mysql.UserRepositoryMySQL;
import es.logixs.service.UsersCompanyService;

/**
 * Hello world!
 */
public final class App {
   
    public static void main(String[] args) {
       
        UserRepository repoUsers= new UserRepositoryMySQL();
        CompaniesRepository repoCompanies= new CompaniesRepositoryMySQL();
        UsersCompanyService servicio= new UsersCompanyService(repoUsers, repoCompanies);

        for (Companies c: servicio.findAllCompanies()) {

            System.out.println(c.getName());
            System.out.println(c.getObjectid());
        }

      


       
        
    
    }
}
