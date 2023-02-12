package task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import task.model.Client;
import task.service.ClientService;
import task.service.FileUploader;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final FileUploader fileUploader;
    private final ClientService clientService;

    @PostMapping(value = "upload")
    public ResponseEntity<HttpStatus> saveClients(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                                 .build();
        fileUploader.saveFiles(file);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .build();
    }

    @GetMapping
    public Client getClientById(@RequestParam Long id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        clientService.deleteById(id);
    }

}
