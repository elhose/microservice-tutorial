package tt.psc.com.microservicetutorial.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tt.psc.com.microservicetutorial.web.model.BeerCustomer;
import tt.psc.com.microservicetutorial.web.services.BeerCustomerService;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class BeerCustomerController {

    private BeerCustomerService beerCustomerService;

    @Autowired
    public BeerCustomerController(BeerCustomerService beerCustomerService) {
        this.beerCustomerService = beerCustomerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<BeerCustomer> getCustomer(@PathVariable("customerId")UUID customerId){
        return new ResponseEntity<>(beerCustomerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerCustomer> addCustomer(@Valid @RequestBody BeerCustomer beerCustomer){
        BeerCustomer savedCustomer = beerCustomerService.addCustomer(beerCustomer);

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Location", "http://localhost:8080/api/v1/customer" + savedCustomer.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerCustomer> editBeer(@Valid @RequestBody BeerCustomer beerCustomer, @PathVariable("beerId") UUID beerId){
        beerCustomerService.editBeerById(beerCustomer, beerId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerCustomerService.deleteBeer(beerId);
    }

}
