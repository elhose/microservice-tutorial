package tt.psc.com.microservicetutorial.web.services;

import org.springframework.stereotype.Service;
import tt.psc.com.microservicetutorial.web.model.BeerDto;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .name("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }
}
