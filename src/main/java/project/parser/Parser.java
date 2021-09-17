package project.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import project.domain.Share;
import project.reader.UrlReader;

import java.io.IOException;
import java.util.List;

public class Parser {

    private final ObjectMapper mapper;
    private final String path;

    Parser(String path) {
        this.mapper = new ObjectMapper();
        this.path = path;
    }

    public List<Share> sharesFromJson() throws IOException {
        String json = UrlReader.readFromUrl(path);
        return mapper.reader()
                .forType(new TypeReference<List<Share>>() {
                })
                .readValue(json);
    }
}
