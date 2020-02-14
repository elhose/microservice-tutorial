package tt.psc.com.microservicetutorial.web.services;

import org.springframework.stereotype.Service;
import tt.psc.com.microservicetutorial.web.model.BeerCustomer;

import java.util.UUID;

@Service
public class BeerCustomerServiceImpl implements BeerCustomerService {

    @Override
    public BeerCustomer getCustomerById(UUID customerId) {
        return new BeerCustomer().builder()
                .id(UUID.randomUUID())
                .name("TOMEK PIZDOTRZĄS")
                .build();
    }
}
