package greedzCorp.pocketGym.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRICE")
    private String price;
    @Column(name = "PRICE_TYPE") //döviz tipi
    private String priceType;
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Column(name = "IS_ACTV")
    private int isActv;
}
