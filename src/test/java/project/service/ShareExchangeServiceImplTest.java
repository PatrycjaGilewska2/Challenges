package project.service;

import org.junit.jupiter.api.Test;
import project.domain.ShareExchangePerDateWithSymbols;
import project.domain.ShareSymbolWithDailyGain;
import project.service.impl.ShareExchangeServiceImpl;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static project.common.StringConstants.*;

class ShareExchangeServiceImplTest {

    @Test
    void getLargestDailyGainPerDateForEachExchange_withExampleDataJson() throws IOException {
        //given
        ShareExchangeServiceImpl service = new ShareExchangeServiceImpl(EXAMPLE_JSON_PATH);
        //when
        List<ShareExchangePerDateWithSymbols> largestDailyGainPerDateForEachExchange = service.getShareExchangePerDateWithSymbolsAndTheLargestDailyGain(DATE);
        //then
        assertThat(largestDailyGainPerDateForEachExchange).hasSize(1);
        ShareExchangePerDateWithSymbols actualShareExchange = largestDailyGainPerDateForEachExchange.get(0);
        assertThat(actualShareExchange.getDate()).isEqualTo(DATE);
        assertThat(actualShareExchange.getExchange()).isEqualTo("XNAS");
        assertThat(actualShareExchange.getSymbols()).hasSize(1);
        ShareSymbolWithDailyGain actualSymbol = actualShareExchange.getSymbols().get(0);
        assertThat(actualSymbol.getSymbol()).isEqualTo("MSFT");
        assertThat(actualSymbol.getDailyGain()).isEqualTo(0.1499939f);
    }

    @Test
    void getLargestDailyGainPerDateForEachExchange_withFullDataJson() throws IOException {
        //given
        ShareExchangeServiceImpl service = new ShareExchangeServiceImpl(FULL_JSON_PATH);
        //when
        List<ShareExchangePerDateWithSymbols> largestDailyGainPerDateForEachExchange = service.getShareExchangePerDateWithSymbolsAndTheLargestDailyGain(DATE);
        //then
        assertThat(largestDailyGainPerDateForEachExchange).hasSize(2);
    }

    @Test
    void shouldThrowAnException_whenThereIsNoFile() {
        //given
        ShareExchangeServiceImpl service = new ShareExchangeServiceImpl(WRONG_JSON_PATH);
        //then
        assertThatThrownBy(() -> service.getShareExchangePerDateWithSymbolsAndTheLargestDailyGain(DATE)).isInstanceOf(NoSuchFileException.class);
    }
}