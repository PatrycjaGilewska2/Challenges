package project.service;

import org.junit.jupiter.api.Test;
import project.domain.ShareExchangePerDateWithSymbols;
import project.service.impl.ShareExchangeServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShareExchangeServiceImplTest {

    private ShareExchangeServiceImpl myInterface = new ShareExchangeServiceImpl();

    @Test
    void getLargestDailyGainPerDateForEachExchange() throws IOException {
        List<ShareExchangePerDateWithSymbols> largestDailyGainPerDateForEachExchange = myInterface.getShareExchangePerDateWithSymbolsAndTheLargestDailyGain(LocalDate.of(2020, 8, 7));
        assertThat(largestDailyGainPerDateForEachExchange).hasSize(2);
    }
}