package greedzCorp.pocketGym.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GYMS")
public class GymEntity extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "GYM_NAME")
    private String gymName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "district")
    private String district;
}
