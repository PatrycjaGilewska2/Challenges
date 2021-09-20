package project.helper;

import project.domain.Share;
import project.domain.ShareExchangePerDateWithSymbols;
import project.mapper.ShareMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShareHelper {

    private ShareHelper() {
    }

    public static List<ShareExchangePerDateWithSymbols> getExchangesWithSymbols(List<List<Share>> listOfSharesPerExchange) {
        return listOfSharesPerExchange.stream().map(ShareMapper::mapToShareExchangePerDateWithSymbols).collect(Collectors.toList());
    }

    public static List<List<Share>> getListOfGroupedSharesForADatePerExchange(LocalDate date, List<Share> shares) {
        return new ArrayList<>(shares.stream().filter(share -> share.getDate().equals(date)).collect(Collectors.groupingBy(Share::getExchange)).values());
    }

}
