package task.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static task.util.TestUtil.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import task.repository.ClientRepository;

@ExtendWith(MockitoExtension.class)
class FileUploaderTest {

    @Mock
    private ClientRepository repository;
    @InjectMocks
    private FileUploader uploader;

    @Test
    void shouldSaveOnlyValidEntities() throws IOException {
        uploader.saveFiles(getMockMultipartFile());
        verify(repository).save(getClient1());
        verify(repository).save(getClient2());
        verify(repository, times(0)).save(getClient3());
    }

}
