package tt.psc.com.microservicetutorial.web.mappers;

import org.mapstruct.Mapper;
import tt.psc.com.microservicetutorial.domain.Beer;
import tt.psc.com.microservicetutorial.web.model.BeerDto;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
