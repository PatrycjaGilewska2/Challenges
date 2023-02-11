package task.service;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import task.repository.ClientRepository;

@ExtendWith(MockitoExtension.class)
class FileUploaderTest {

    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private FileUploader uploader;

    private static final String CSV_PATH = "src/test/resources/example.csv";

    @Test
    void get() throws FileNotFoundException {
//        List<ClientDto> csvFile = uploader.getCsvFile();
//        assertNotNull(csvFile);
    }

}
