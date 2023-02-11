package task.service;

import java.io.BufferedReader;
import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBeanBuilder;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import task.model.Client;
import task.model.ClientNode;
import task.repository.ClientRepository;

@Service
@AllArgsConstructor
@Log4j2
public class FileUploader implements Serializable {

    private final ClientRepository repository;

    public void saveFiles(BufferedReader reader) {
        new CsvToBeanBuilder<ClientNode>(reader).withType(ClientNode.class)
                                                .build()
                                                .parse()
                                                .stream()
                                                .map(this::getClient)
                                                .forEach(this::saveClient);
    }

    private void saveClient(Client node) {
        log.info("Saving client by id {}", node.getPrimaryKey());
        repository.save(node);
    }

    private Client getClient(ClientNode node) {
        return new Client(node.getPrimaryKey(), node.getName(), node.getDescription(), node.getUpdatedTimestamp());
    }

}
