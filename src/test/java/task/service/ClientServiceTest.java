package task.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static task.util.TestUtil.getClient1;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import task.exception.ClientNotFoundException;
import task.model.Client;
import task.repository.ClientRepository;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository repository;
    @InjectMocks
    private ClientService service;

    @Test
    void shouldReturnClientFoundById() {
        when(repository.findById(1L)).thenReturn(Optional.of(getClient1()));
        Client existingClient = service.getClientById(1L);
        assertNotNull(existingClient);
    }

    @Test
    void shouldThrowClientNotFoundException() {
        Exception exception = assertThrows(ClientNotFoundException.class, () -> service.getClientById(1L));
        String expectedMessage = "Client by id 1 has not been found";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void shouldDeleteClient_foundById() {
        service.deleteById(1L);
        verify(repository).deleteById(1L);
    }

}
