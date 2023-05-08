package es.logixs.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.logixs.config.ConfiguradorSpring;
import es.logixs.domain.Products;
import es.logixs.domain.Requests;
import es.logixs.domain.Sales;
import es.logixs.service.SalesProductsRequestsService;

public class AppSalesProductsRequests {
    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(ConfiguradorSpring.class);

        SalesProductsRequestsService servicio = contexto.getBean(SalesProductsRequestsService.class);

        for (Sales s : servicio.findAllSales()) {
            System.out.println(s.getId());
            System.out.println(s.getClientId());
        }

        for (Products p : servicio.findAllProducts()) {
            System.out.println(p.getId());
            System.out.println(p.getCategory());
        }

        for (Requests r : servicio.findAllRequests()) {
            System.out.println(r.getId());
            System.out.println(r.getOwnerId());
        }
        contexto.close();
    }
}
