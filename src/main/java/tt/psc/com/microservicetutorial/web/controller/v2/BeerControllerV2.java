package tt.psc.com.microservicetutorial.web.controller.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tt.psc.com.microservicetutorial.web.model.v2.BeerDtoV2;
import tt.psc.com.microservicetutorial.services.v2.BeerServiceV2;

import javax.validation.Valid;
import java.util.UUID;

//@Validated // to use validation on mehods
@RequestMapping("api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    @Autowired
    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(/*@NotNull*/ @PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity putBeer(@Valid /*@NotNull*/ @RequestBody BeerDtoV2 beerDtoV2) {

        BeerDtoV2 savedBeer = beerServiceV2.saveBeer(beerDtoV2);

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Location", "http://localhost:8080/api/v2/beer" + savedBeer.getId().toString()); /*if error check v2*/
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity editBeer(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDtoV2) {

        beerServiceV2.updateBeer(beerDtoV2, beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerServiceV2.deleteBeer(beerId);
    }
}
