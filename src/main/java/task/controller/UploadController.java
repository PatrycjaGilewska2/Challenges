package task.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import task.model.Client;
import task.service.ClientService;
import task.service.FileUploader;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class UploadController {

    private final FileUploader uploader;
    private final ClientService clientService;

    @PostMapping(value = "upload")
    public void saveClients(@RequestParam("file") MultipartFile file) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            uploader.saveFiles(br);
        }
    }
    // nie zapisywać do bd nieważnych node'ów
    // walidować, czy id już nie istnieje ??

    @GetMapping
    public Client getClientById(@RequestParam Long id) {
        return clientService.getClientById(id);
    }

}
