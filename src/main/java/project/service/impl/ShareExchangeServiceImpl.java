package project.service.impl;

import project.domain.ShareExchangePerDateWithSymbols;
import project.parser.Parser;
import project.service.ShareExchangeService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static project.helper.ShareHelper.getExchangesWithSymbols;
import static project.helper.ShareHelper.getListOfGroupedSharesForADatePerExchange;

public class ShareExchangeServiceImpl implements ShareExchangeService {

    private final Parser parser = new Parser();

    public List<ShareExchangePerDateWithSymbols> getShareExchangePerDateWithSymbolsAndTheLargestDailyGain(LocalDate date) throws IOException {
        return getExchangesWithSymbols(getListOfGroupedSharesForADatePerExchange(date, parser.sharesFromJson()));
    }
}
