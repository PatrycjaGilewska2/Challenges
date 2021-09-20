package project.domain;

public class ShareSymbolWithDailyGain {

    float dailyGain;
    String symbol;

    public ShareSymbolWithDailyGain(float dailyGain, String symbol) {
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
