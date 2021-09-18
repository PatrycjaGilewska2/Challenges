package project.domain;

import java.time.LocalDate;
import java.util.List;

public class ShareExchangePerDateWithSymbols {

    LocalDate date;
    String exchange;
    List<ShareSymbolWithDailyGain> symbols;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setSymbols(List<ShareSymbolWithDailyGain> symbols) {
        this.symbols = symbols;
    }
}