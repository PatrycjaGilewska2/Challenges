package task.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBeanBuilder;

import task.model.ClientDto;

@Service
public class CsvUploader implements Serializable {

    private static final String CSV_PATH = "src/test/resources/example.csv";

    public List<ClientDto> getCsvFile() throws FileNotFoundException {

        File file = new File(CSV_PATH);

        return new CsvToBeanBuilder<ClientDto>(new FileReader(file)).withType(ClientDto.class)
                                                                    .build()
                                                                    .parse();

    }

}
