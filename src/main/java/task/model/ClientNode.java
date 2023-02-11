package task.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;

@Data
public class ClientNode {

    @CsvBindByName(column = "PRIMARY_KEY")
    private Long primaryKey;
    @CsvBindByName(column = "NAME")
    private String name;
    @CsvBindByName(column = "DESCRIPTION")
    private String description;
    @CsvBindByName(column = "UPDATED_TIMESTAMP")
    private String updatedTimestamp;

}
