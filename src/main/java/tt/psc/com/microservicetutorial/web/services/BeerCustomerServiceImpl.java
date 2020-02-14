package tt.psc.com.microservicetutorial.web.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tt.psc.com.microservicetutorial.web.model.BeerCustomer;

import java.util.UUID;

@Slf4j
@Service
public class BeerCustomerServiceImpl implements BeerCustomerService {

    @Override
    public void deleteBeer(UUID beerId) {
        log.info("DELETE TESTING");
    }

    @Override
    public void editBeerById(BeerCustomer beerCustomer, UUID beerId) {
        log.info("TESTING PUT");
    }

    @Override
    public BeerCustomer addCustomer(BeerCustomer beerCustomer) {
        return BeerCustomer.builder()
                .name("KLIENT MIESIĄCA")
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public BeerCustomer getCustomerById(UUID customerId) {
        return BeerCustomer.builder()
                .id(UUID.randomUUID())
                .name("TOMEK PIZDOTRZĄS")
                .build();
    }
}
