package tt.psc.com.microservicetutorial.web.services;

import org.springframework.stereotype.Service;
import tt.psc.com.microservicetutorial.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
