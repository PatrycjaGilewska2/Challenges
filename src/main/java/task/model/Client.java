package task.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    private Long primaryKey;
    private String name;
    private String description;
    private String updatedTimestamp;

}
