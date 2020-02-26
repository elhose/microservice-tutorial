package tt.psc.com.microservicetutorial.services;

import tt.psc.com.microservicetutorial.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveBeer(BeerDto beerDto);

    void updateBeer(BeerDto beerDto, UUID beerId);

    void deleteBeer(UUID beerId);
}
