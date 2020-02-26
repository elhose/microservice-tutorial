package tt.psc.com.microservicetutorial.web.mappers;

import org.mapstruct.Mapper;
import tt.psc.com.microservicetutorial.domain.Customer;
import tt.psc.com.microservicetutorial.web.model.BeerCustomer;

@Mapper
public interface CustomerMapper {
    BeerCustomer customerToBeerCustomer(Customer customer);
    Customer beerCustomerToCustomer(BeerCustomer beerCustomer);
}
