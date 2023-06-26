package alianz.model.api;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Reading {

    LocalDateTime timestamp;
    String value;
}
