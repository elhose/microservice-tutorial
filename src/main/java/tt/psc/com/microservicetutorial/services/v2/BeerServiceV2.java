package tt.psc.com.microservicetutorial.services.v2;

import tt.psc.com.microservicetutorial.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveBeer(BeerDtoV2 beerDtoV2);

    void updateBeer(BeerDtoV2 beerDtoV2, UUID beerId);

    void deleteBeer(UUID beerId);
}
