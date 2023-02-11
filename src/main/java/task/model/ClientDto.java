package task.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class ClientDto {

    @CsvBindByName(column = "PRIMARY_KEY")
    private String key;
    @CsvBindByName(column = "NAME")
    private String name;
    @CsvBindByName(column = "DESCRIPTION")
    private String description;
    @CsvBindByName(column = "UPDATED_TIMESTAMP")
    private String timestamp;

}
