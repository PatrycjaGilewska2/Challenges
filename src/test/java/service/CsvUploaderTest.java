package service;

import model.DatabaseDto;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvUploaderTest {

    private final CsvUploader uploader = new CsvUploader();

    //dlaczego nie dodaje się klucz?
    @Test
    void get() throws FileNotFoundException {
        List<DatabaseDto> csvFile = uploader.getCsvFile();
        assertNotNull(csvFile);
    }

}