package tt.psc.com.microservicetutorial.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tt.psc.com.microservicetutorial.web.model.BeerDto;
import tt.psc.com.microservicetutorial.web.services.BeerService;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity putBeer(@Valid @RequestBody BeerDto beerDto) {

        BeerDto savedBeer = beerService.saveBeer(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Location", "http://localhost:8080/api/v1/beer" + savedBeer.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity editBeer(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {

        beerService.updateBeer(beerDto, beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);
    }
}
