package project.domain;

import lombok.AllArgsConstructor;

public class GainPerDate {

    float dailyGain;
    String symbol;

    public GainPerDate(float dailyGain, String symbol) {
        this.dailyGain = dailyGain;
        this.symbol = symbol;
    }

    public float getDailyGain() {
        return dailyGain;
    }

    public String getSymbol() {
        return symbol;
    }
}
