package alianz.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "city-hall")
public class City {

    @Id
    private Long primaryKey;
    @Column(name="CITY_NAME")
    private String name;

    @OneToMany
    @JoinColumn(name="DISTRICT_ID")
    private List<District> districts;

}
