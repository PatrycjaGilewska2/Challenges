package alianz.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @Column(name = "SENSOR_ID")
    private Long primaryKey;

    @OneToMany
    @JoinColumn(name = "DISTRICT_ID")
    private List<Measurement> measurements;
}
