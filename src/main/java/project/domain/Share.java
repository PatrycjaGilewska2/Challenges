package project.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Share {

    @JsonProperty("date")
    Date date;
    @JsonProperty("close")
    float closePrice;
    @JsonProperty("exchange")
    String exchange;
    @JsonProperty("high")
    float highPrice;
    @JsonProperty("low")
    float lowPrice;
    @JsonProperty("open")
    float openPrice;
    @JsonProperty("symbol")
    String symbol;

}
