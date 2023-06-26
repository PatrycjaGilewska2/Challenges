package alianz.controller;

import alianz.model.api.Reading;
import alianz.model.entity.District;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//reading - odczyt
@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class CityHallController {

    //dostarczenie danych z czujnika do serwera

    //czujniki muszą powiązać odczyty z danym kontem klienta

    //każdy ratusz może sprawdzić poziom CO2 z danych historycznych (per district)
    public List<Reading> getCO2ReadingDistrictId(District district) {
        return List.of();
    }


    //make sure that each city hall can only query their own sensor readings

}
