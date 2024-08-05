package greedzCorp.pocketGym.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STATES")
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SHRT_CODE")  // CANCELLED
    private String shrtCode;
    @Column(name = "STATE_NAME") // İptal Edildi
    private String stateName;
    @Column(name = "DATA_TYPE")  // PRODUCT_ORDERS
    private String dataType;

}
