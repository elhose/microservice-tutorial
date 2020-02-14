package tt.psc.com.microservicetutorial.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeerDto {
    private UUID id;
    private String name;
    private String beerStyle;
    private Long upc;

}
