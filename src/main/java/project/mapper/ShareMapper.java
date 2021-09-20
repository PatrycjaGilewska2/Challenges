package project.mapper;

import project.domain.Share;
import project.domain.ShareExchangePerDateWithSymbols;
import project.domain.ShareSymbolWithDailyGain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShareMapper {

    private ShareMapper() {
    }

    public static ShareExchangePerDateWithSymbols mapToShareExchangePerDateWithSymbols(List<Share> listOfShares) {
        Share share = listOfShares.stream().findFirst().orElseThrow();
        return new ShareExchangePerDateWithSymbols(share.getDate(), share.getExchange(), getListOfSymbolWithLargestDailyGain(listOfShares));
    }

    private static List<ShareSymbolWithDailyGain> getListOfSymbolWithLargestDailyGain(List<Share> shares) {
        return getListOfGroupedSymbolsWithDailyGain(shares).stream()
                .map(listOfSymbols -> listOfSymbols.stream().max(Comparator.comparing(ShareSymbolWithDailyGain::getDailyGain)).orElseThrow())
                .collect(Collectors.toList());
    }

    private static List<List<ShareSymbolWithDailyGain>> getListOfGroupedSymbolsWithDailyGain(List<Share> shares) {
        return new ArrayList<>(shares.stream()
                .map(ShareMapper::mapToShareSymbolWithDailyGain)
                .collect(Collectors.groupingBy(ShareSymbolWithDailyGain::getSymbol)).values());
    }

    private static ShareSymbolWithDailyGain mapToShareSymbolWithDailyGain(Share share) {
        return new ShareSymbolWithDailyGain(countShareDailyGain(share), share.getSymbol());
    }

    private static float countShareDailyGain(Share share) {
        return share.getClosePrice() - share.getOpenPrice();
    }
}
