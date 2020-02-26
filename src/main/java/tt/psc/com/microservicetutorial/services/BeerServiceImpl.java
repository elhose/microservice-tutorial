package tt.psc.com.microservicetutorial.services;

import org.springframework.stereotype.Service;
import tt.psc.com.microservicetutorial.web.model.BeerDto;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void deleteBeer(UUID beerId) {
        System.out.println("TEST DELETETETETETE");
    }

    @Override
    public void updateBeer(BeerDto beerDto, UUID beerId) {
        System.out.println("TESTING");
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .name("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }
}
