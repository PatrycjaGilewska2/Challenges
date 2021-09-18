package project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ExchangeSth {

    LocalDate date;
    String exchange;
    List<GainPerDate> gains;


    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setGains(List<GainPerDate> gains) {
        this.gains = gains;
    }
}
