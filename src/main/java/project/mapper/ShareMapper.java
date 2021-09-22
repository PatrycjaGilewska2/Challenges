package project.mapper;

import project.domain.Share;
import project.domain.ShareSymbolWithDailyGain;

public class ShareMapper {

    private ShareMapper() {
    }

    public static ShareSymbolWithDailyGain mapToShareSymbolWithDailyGain(Share share) {
        return new ShareSymbolWithDailyGain(share.getDate(), countShareDailyGain(share), share.getSymbol());
    }

    private static float countShareDailyGain(Share share) {
        return Math.round(share.getClosePrice() - share.getOpenPrice());
    }
}
