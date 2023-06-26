package alianz.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @Column(name = "MEASUREMENT_ID")
    private Long primaryKey;

    @Column(name = "TIMESTAMP")
    private LocalDateTime timestamp;

    @Column(name = "READING")
    private Float value;

}
