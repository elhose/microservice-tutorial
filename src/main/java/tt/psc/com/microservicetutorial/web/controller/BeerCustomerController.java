package tt.psc.com.microservicetutorial.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tt.psc.com.microservicetutorial.web.model.BeerCustomer;
import tt.psc.com.microservicetutorial.web.services.BeerCustomerService;

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
}
