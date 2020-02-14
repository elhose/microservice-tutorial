package tt.psc.com.microservicetutorial.web.services;

import tt.psc.com.microservicetutorial.web.model.BeerCustomer;

import java.util.UUID;

public interface BeerCustomerService {
    BeerCustomer getCustomerById(UUID customerId);

    BeerCustomer addCustomer(BeerCustomer beerCustomer);

    void editBeerById(BeerCustomer beerCustomer, UUID beerId);

    void deleteBeer(UUID beerId);
}
