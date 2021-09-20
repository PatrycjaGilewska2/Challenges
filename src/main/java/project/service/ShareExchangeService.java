package project.service;

import project.domain.ShareExchangePerDateWithSymbols;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface ShareExchangeService {

    List<ShareExchangePerDateWithSymbols> getShareExchangePerDateWithSymbolsAndTheLargestDailyGain(LocalDate date) throws IOException;
}
