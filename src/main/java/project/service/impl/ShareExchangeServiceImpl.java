package project.service.impl;

import project.domain.Share;
import project.domain.ShareExchangePerDateWithSymbols;
import project.domain.ShareSymbolWithDailyGain;
import project.parser.Parser;
import project.service.ShareExchangeService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShareExchangeServiceImpl implements ShareExchangeService {

    Parser parser = new Parser();

    public List<ShareExchangePerDateWithSymbols> getShareExchangePerDateWithSymbolsAndTheLargestDailyGain(LocalDate date) throws IOException {
        List<Share> shares = parser.sharesFromJson();

        //odfiltrowac te ze zla data
        List<Share> filtered = shares.stream()
                .filter(share -> share.getDate().equals(date))
                .collect(Collectors.toList());

        //zabrac z odfiltrowanych wszystkie , ktore sa per exchange
        Map<String, List<Share>> sharesPerExchange =
                filtered.stream().collect(Collectors.groupingBy(Share::getExchange));

        //lista wewnetrzna zawiwera share'y o tym samym exhange'u i dacie
        List<List<Share>> listOfList = new ArrayList<>(sharesPerExchange.values());

        List<ShareExchangePerDateWithSymbols> exchanges = new ArrayList<>();

        listOfList.forEach(list -> {
            ShareExchangePerDateWithSymbols shareExchangePerDateWithSymbols = new ShareExchangePerDateWithSymbols();
            Share share1 = list.get(0);

            shareExchangePerDateWithSymbols.setDate(share1.getDate());
            shareExchangePerDateWithSymbols.setExchange(share1.getExchange());

            List<ShareSymbolWithDailyGain> collect = list.stream().map(this::mapToGain).collect(Collectors.toList());


            Map<String, List<ShareSymbolWithDailyGain>> collect1 = collect.stream()
                    .collect(Collectors.groupingBy(ShareSymbolWithDailyGain::getSymbol));

            List<ShareSymbolWithDailyGain> gains = new ArrayList<>();

            List<List<ShareSymbolWithDailyGain>> listOfGains = new ArrayList<>(collect1.values());
            listOfGains.forEach(list1 -> {
                        gains.add(list1.stream().max(Comparator.comparing(ShareSymbolWithDailyGain::getDailyGain)).orElseThrow());

                    }
            );
            shareExchangePerDateWithSymbols.setSymbols(gains);
            exchanges.add(shareExchangePerDateWithSymbols);
        });
        return exchanges;
    }

    private ShareSymbolWithDailyGain mapToGain(Share share) {
        float dailyGain = countGain(share);
        return new ShareSymbolWithDailyGain(dailyGain, share.getSymbol());
    }

    private float countGain(Share share) {
        return share.getClosePrice() - share.getOpenPrice();
    }


}
