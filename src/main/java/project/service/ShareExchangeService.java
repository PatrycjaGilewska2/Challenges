package project.service;

import project.domain.Share;
import project.domain.ShareSymbolWithDailyGain;
import project.mapper.ShareMapper;
import project.parser.Parser;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ShareExchangeService {

    private final Parser parser;

    public ShareExchangeService(String path) {
        this.parser = new Parser(path);
    }

    public List<ShareSymbolWithDailyGain> getSymbolsWithDailyGainPerDate(LocalDate date) throws IOException {
        List<Share> shares = parser.sharesFromJson();
        return shares.stream()
                .filter(share -> share.getDate().equals(date))
                .map(ShareMapper::mapToShareSymbolWithDailyGain)
                .collect(toList());
    }
}
