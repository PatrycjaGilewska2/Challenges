package task.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;

import task.model.ClientDto;

class CsvUploaderTest {

    private final CsvUploader uploader = new CsvUploader();

    @Test
    void get() throws FileNotFoundException {
        List<ClientDto> csvFile = uploader.getCsvFile();
        assertNotNull(csvFile);
    }

}
