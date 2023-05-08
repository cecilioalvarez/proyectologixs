package es.logixs.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.logixs.config.ConfiguradorSpring;
import es.logixs.domain.Companies;
import es.logixs.service.UsersCompanyService;

/**
 * Hello world!
 */
public final class App {
   

    public static void main(String[] args) {
       

        AnnotationConfigApplicationContext contexto=
         new AnnotationConfigApplicationContext(ConfiguradorSpring.class);

       
        UsersCompanyService servicio=contexto.getBean(UsersCompanyService.class);

        for (Companies c: servicio.findAllCompanies()) {

            System.out.println(c.getName());
            System.out.println(c.getObjectid());
        }
        contexto.close();

      


       
        
    
    }
}
