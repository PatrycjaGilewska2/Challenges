package project.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
public class Share {

    @JsonProperty("date")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate date;
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

    public LocalDate getDate() {
        return date;
    }

    public float getClosePrice() {
        return closePrice;
    }

    public String getExchange() {
        return exchange;
    }

    public float getHighPrice() {
        return highPrice;
    }

    public float getLowPrice() {
        return lowPrice;
    }

    public float getOpenPrice() {
        return openPrice;
    }

    public String getSymbol() {
        return symbol;
    }
}
