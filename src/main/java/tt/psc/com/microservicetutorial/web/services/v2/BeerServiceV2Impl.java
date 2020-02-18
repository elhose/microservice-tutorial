package tt.psc.com.microservicetutorial.web.services.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tt.psc.com.microservicetutorial.web.model.v2.BeerDtoV2;
import tt.psc.com.microservicetutorial.web.model.v2.BeerStyleEnum;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .name("DOBRE BIWO")
                .beerStyle(BeerStyleEnum.IPA)
                .build();
    }

    @Override
    public BeerDtoV2 saveBeer(BeerDtoV2 beerDtoV2) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(BeerDtoV2 beerDtoV2, UUID beerId) {
        log.warn("TEST UPDATETE");
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.warn("DELET THES");
    }
}
