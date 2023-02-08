package task.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;

import task.model.DatabaseDto;

class CsvUploaderTest {

    private final CsvUploader uploader = new CsvUploader();

    // dlaczego nie dodaje się klucz?
    @Test
    void get() throws FileNotFoundException {
        List<DatabaseDto> csvFile = uploader.getCsvFile();
        assertNotNull(csvFile);
    }

}
