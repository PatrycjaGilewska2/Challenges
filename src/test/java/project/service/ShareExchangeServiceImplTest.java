package project.service;

import org.junit.jupiter.api.Test;
import project.domain.ShareExchangePerDateWithSymbols;
import project.domain.ShareSymbolWithDailyGain;
import project.service.impl.ShareExchangeServiceImpl;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ShareExchangeServiceImplTest {

    private final String EXAMPLE_DATA_PATH = "src/test/resources/exampleData.json";
    private final String FULL_DATA_PATH = "src/test/resources/fullData.json";
    private final String WRONG_DATA_PATH = "src/test/resources/abc.json";
    private final LocalDate DATE = LocalDate.of(2020, 8, 7);

    @Test
    void getLargestDailyGainPerDateForEachExchange_withExampleDataJson() throws IOException {
        //given
        ShareExchangeServiceImpl service = new ShareExchangeServiceImpl(EXAMPLE_DATA_PATH);
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
        ShareExchangeServiceImpl service = new ShareExchangeServiceImpl(FULL_DATA_PATH);
        //when
        List<ShareExchangePerDateWithSymbols> largestDailyGainPerDateForEachExchange = service.getShareExchangePerDateWithSymbolsAndTheLargestDailyGain(DATE);
        //then
        assertThat(largestDailyGainPerDateForEachExchange).hasSize(2);
    }

    @Test
    void shouldThrowAnException_whenThereIsNoFile() {
        //given
        ShareExchangeServiceImpl service = new ShareExchangeServiceImpl(WRONG_DATA_PATH);
        //then
        assertThatThrownBy(() -> service.getShareExchangePerDateWithSymbolsAndTheLargestDailyGain(DATE)).isInstanceOf(NoSuchFileException.class);
    }
}