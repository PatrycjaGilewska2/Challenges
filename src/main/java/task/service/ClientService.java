package task.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import task.exception.ClientNotFoundException;
import task.model.Client;
import task.repository.ClientRepository;

@Service
@AllArgsConstructor
@Log4j2
public class ClientService {

    private final ClientRepository repository;

    public Client getClientById(Long id) {
        log.info("Getting client by id {}", id);
        return repository.findById(id)
                         .orElseThrow(() -> new ClientNotFoundException(String.format("Client by id %s has not been found",
                                                                                      id)));
    }

    public void deleteById(Long id) {
        log.info("Deleting client by id {}", id);
        repository.deleteById(id);
    }

}
