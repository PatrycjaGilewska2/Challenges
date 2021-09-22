package project.domain;

import java.time.LocalDate;

public class ShareSymbolWithDailyGain {

    private final LocalDate date;
    private final float dailyGain;
    private final String symbol;

    public ShareSymbolWithDailyGain(LocalDate date, float dailyGain, String symbol) {
        this.date = date;
        this.dailyGain = dailyGain;
        this.symbol = symbol;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getDailyGain() {
        return dailyGain;
    }

    public String getSymbol() {
        return symbol;
    }
}
