package es.logixs.main;

import es.logixs.config.ConfiguradorSpring;
import es.logixs.domain.Companies;
import es.logixs.domain.CounterOffers;
import es.logixs.domain.Offer;
import es.logixs.service.OffersService;
import es.logixs.service.UsersCompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppCounterOffers {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext contexto =
            new AnnotationConfigApplicationContext(ConfiguradorSpring.class);

        OffersService servicio = contexto.getBean(OffersService.class);

        for (CounterOffers counterOffers : servicio.findAllCounterOffer()) {

            System.out.println(counterOffers.getName());
            System.out.println(counterOffers.getId());
        }

        for (Offer offer : servicio.findAllOffers()) {

            System.out.println(offer.getName());
            System.out.println(offer.getId());
        }
        contexto.close();
    }
}
