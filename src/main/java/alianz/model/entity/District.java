package alianz.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "district")
public class District {

    @Id
    @Column(name="DISTRICT_ID")
    private Long primaryKey;

    @OneToOne
    @JoinColumn(name="SENSOR_ID")
    private Sensor sensor;

}
