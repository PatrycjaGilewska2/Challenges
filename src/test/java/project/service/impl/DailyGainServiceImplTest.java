package project.service.impl;

import org.junit.jupiter.api.Test;
import project.domain.ExchangeSth;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

class DailyGainServiceImplTest {

    private DailyGainServiceImpl dailyGainService = new DailyGainServiceImpl();

    @Test
    void getLargestDailyGainPerDateForEachExchange() throws IOException {
        List<ExchangeSth> largestDailyGainPerDateForEachExchange = dailyGainService.getLargestDailyGainPerDateForEachExchange(LocalDate.of(2020, 8, 7));
    }
}