package project.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import project.domain.Share;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Parser {

    private final String path;
    private final ObjectMapper mapper = new ObjectMapper();

    public Parser(String path) {
        this.path = path;
    }

    public List<Share> sharesFromJson() throws IOException {
        String json = stringFromJson();
        return mapper.reader()
                .forType(new TypeReference<List<Share>>() {
                })
                .readValue(json);
    }

    private String stringFromJson() throws IOException {
        return Files.readString(Path.of(path));
    }
}
