package greedzCorp.pocketGym.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_ORDERS")
public class ProductOrderEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "DATA_TYPE")
    private String dataType;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "ORDER_STATE")
    private Long orderState;

    @Column(name = "ORDER_TYPE")
    private String orderType; // satın alma, kupon, çekiliş vb.
}
