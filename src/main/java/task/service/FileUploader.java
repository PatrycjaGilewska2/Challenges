package task.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBeanBuilder;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import task.exception.UploadException;
import task.model.Client;
import task.model.ClientNode;
import task.repository.ClientRepository;

@Service
@AllArgsConstructor
@Log4j2
public class FileUploader implements Serializable {

    private final ClientRepository repository;

    public void saveFiles(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            new CsvToBeanBuilder<ClientNode>(reader).withType(ClientNode.class)
                                                    .build()
                                                    .parse()
                                                    .stream()
                                                    .filter(this::validateNode)
                                                    .map(this::getClient)
                                                    .forEach(this::saveClient);
        } catch (IOException e) {
            throw new UploadException("Not able to save file");
        }
    }

    private boolean validateNode(ClientNode node) {
        return node.getPrimaryKey() != null && isValid(node.getUpdatedTimestamp());
    }

    private boolean isValid(String dateStr) {
        if (dateStr.isEmpty())
            return true;
        try {
            OffsetDateTime.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private void saveClient(Client node) {
        log.info("Saving client by id {}", node.getPrimaryKey());
        repository.save(node);
    }

    private Client getClient(ClientNode node) {
        return new Client(node.getPrimaryKey(), node.getName(), node.getDescription(), node.getUpdatedTimestamp());
    }

}
