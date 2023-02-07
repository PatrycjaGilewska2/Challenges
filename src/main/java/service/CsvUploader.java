package service;

import com.opencsv.bean.CsvToBeanBuilder;
import model.ClientFile;
import model.DatabaseDto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvUploader {

//    record ClientFile (String name, String address) {}

    private static final String CSV_PATH = "src/test/resources/example.csv";

    public List<DatabaseDto> getCsvFile() throws FileNotFoundException {

        File file = new File(CSV_PATH);

        return new CsvToBeanBuilder<ClientFile>(new FileReader(file))
                .withType(ClientFile.class)
                .build()
                .parse()
                .stream()
                .map(this::mapToClientFile)
                .collect(Collectors.toList());

    }

    private DatabaseDto mapToClientFile(ClientFile elem) {
        ZonedDateTime timestamp = ZonedDateTime.from(DateTimeFormatter.ISO_ZONED_DATE_TIME.parse(elem.getTimestamp()));
        return DatabaseDto.builder()
                .key(elem.getKey())
                .description(elem.getDescription())
                .name(elem.getName())
                .timestamp(timestamp)
                .build();
    }
}
