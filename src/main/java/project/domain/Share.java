package project.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Share {

    @JsonProperty("date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;
    @JsonProperty("close")
    private float closePrice;
    @JsonProperty("exchange")
    private String exchange;
    @JsonProperty("high")
    private float highPrice;
    @JsonProperty("low")
    private float lowPrice;
    @JsonProperty("open")
    private float openPrice;
    @JsonProperty("symbol")
    private String symbol;


//    public LocalDate getDate() {
//        return date;
//    }
//
//    public float getClosePrice() {
//        return closePrice;
//    }
//
//    public String getExchange() {
//        return exchange;
//    }
//
//    public float getHighPrice() {
//        return highPrice;
//    }
//
//    public float getLowPrice() {
//        return lowPrice;
//    }
//
//    public float getOpenPrice() {
//        return openPrice;
//    }
//
//    public String getSymbol() {
//        return symbol;
//    }
}
