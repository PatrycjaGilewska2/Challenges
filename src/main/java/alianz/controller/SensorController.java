package alianz.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class SensorController {

    //czujniki muszą powiązać odczyty z danym kontem klienta
    @PostMapping(value = "authenticate")
    public ResponseEntity<HttpStatus> authentication() {


        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
