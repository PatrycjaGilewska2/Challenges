package project.service.impl;

import project.domain.ExchangeSth;
import project.domain.GainPerDate;
import project.domain.Share;
import project.parser.Parser;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DailyGainServiceImpl {

    Parser parser = new Parser();

    public List<ExchangeSth> getLargestDailyGainPerDateForEachExchange(LocalDate date) throws IOException {
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

        List<ExchangeSth> exchanges = new ArrayList<>();

        listOfList.forEach(list -> {
            ExchangeSth exchangeSth = new ExchangeSth();
            Share share1 = list.get(0);

            exchangeSth.setDate(share1.getDate());
            exchangeSth.setExchange(share1.getExchange());

            List<GainPerDate> collect = list.stream().map(this::mapToGain).collect(Collectors.toList());


            Map<String, List<GainPerDate>> collect1 = collect.stream()
                    .collect(Collectors.groupingBy(GainPerDate::getSymbol));

            List<GainPerDate> gains = new ArrayList<>();

            List<List<GainPerDate>> listOfGains = new ArrayList<>(collect1.values());
            listOfGains.forEach(list1 -> {
                        gains.add(list1.stream().max(Comparator.comparing(GainPerDate::getDailyGain)).orElseThrow());

                    }
            );
            exchangeSth.setGains(gains);
            exchanges.add(exchangeSth);
        });
        return exchanges;
    }

    private GainPerDate mapToGain(Share share) {
        float dailyGain = countGain(share);
        return new GainPerDate(dailyGain, share.getSymbol());
    }

    private float countGain(Share share) {
        return share.getClosePrice() - share.getOpenPrice();
    }


}
