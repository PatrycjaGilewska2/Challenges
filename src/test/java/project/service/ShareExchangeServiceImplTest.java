package project.service;

import org.junit.jupiter.api.Test;
import project.domain.ShareExchangePerDateWithSymbols;
import project.service.impl.ShareExchangeServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

class ShareExchangeServiceImplTest {

    private ShareExchangeServiceImpl dailyGainService = new ShareExchangeServiceImpl();

    @Test
    void getLargestDailyGainPerDateForEachExchange() throws IOException {
        List<ShareExchangePerDateWithSymbols> largestDailyGainPerDateForEachExchange = dailyGainService.getShareExchangePerDateWithSymbolsAndTheLargestDailyGain(LocalDate.of(2020, 8, 7));
    }
}