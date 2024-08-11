package greedzCorp.pocketGym.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "DATA_TYPE")
    private String dataType;

    @Column(name = "DATA_TYPE_ID")
    private Long dataTypeId;

    @Column(name = "STOCK")
    private Long stock;

    @Column(name = "TOTAL_STOCK")
    private Long totalStock;

    @Column(name = "PRICE")
    private String price;
}
