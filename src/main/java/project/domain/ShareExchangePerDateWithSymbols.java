package project.domain;

import java.time.LocalDate;
import java.util.List;

public class ShareExchangePerDateWithSymbols {

    LocalDate date;
    String exchange;
    List<ShareSymbolWithDailyGain> symbols;

    public ShareExchangePerDateWithSymbols(LocalDate date, String exchange, List<ShareSymbolWithDailyGain> symbols) {
        this.date = date;
        this.exchange = exchange;
        this.symbols = symbols;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getExchange() {
        return exchange;
    }

    public List<ShareSymbolWithDailyGain> getSymbols() {
        return symbols;
    }
}
