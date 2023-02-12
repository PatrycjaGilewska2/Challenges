package task.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static task.util.TestUtil.getClient1;
import static task.util.TestUtil.getMockMultipartFile;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import task.model.Client;
import task.service.ClientService;
import task.service.FileUploader;

@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

    @Mock
    private FileUploader fileUploader;
    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    @Test
    void shouldReturnClientFoundById() {
        when(clientService.getClientById(1L)).thenReturn(getClient1());
        Client clientById = clientController.getClientById(1L);
        assertNotNull(clientById);
        assertEquals(1L, clientById.getPrimaryKey());
    }

    @Test
    void shouldCheckIfSaveMethodIsCalledFromService() throws IOException {
        MockMultipartFile mockMultipartFile = getMockMultipartFile();
        clientController.saveClients(mockMultipartFile);
        Mockito.verify(fileUploader)
               .saveFiles(mockMultipartFile);
    }

    @Test
    void shouldDelete() {
        clientController.deleteById(1L);
        Mockito.verify(clientService)
               .deleteById(1L);
    }

}
