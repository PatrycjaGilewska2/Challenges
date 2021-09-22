package project.service;

import org.junit.jupiter.api.Test;
import project.domain.ShareSymbolWithDailyGain;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static project.common.StringConstants.DATE;
import static project.common.StringConstants.EXAMPLE_JSON_PATH;

class ShareExchangeServiceTest {

    @Test
    void getLargestDailyGainPerDateForEachExchange_withExampleDataJson() throws IOException {
        //given
        ShareExchangeService service = new ShareExchangeService(EXAMPLE_JSON_PATH);
        //when
        List<ShareSymbolWithDailyGain> symbolsWithDailyGain = service.getSymbolsWithDailyGainPerDate(DATE);
        //then
        assertThat(symbolsWithDailyGain).hasSize(1);
        ShareSymbolWithDailyGain actual = symbolsWithDailyGain.get(0);
        assertThat(actual.getDate()).isEqualTo(DATE);
        assertThat(actual.getSymbol()).isEqualTo("EVR");
        assertThat(actual.getDailyGain()).isEqualTo(15.0f);
    }

}