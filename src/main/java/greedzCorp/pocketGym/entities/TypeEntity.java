package greedzCorp.pocketGym.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TYPES")
public class TypeEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SHRT_CODE") //PROD_ORD
    private String shrtCode;

    @Column(name = "TYPE_NAME") //örn: Product Orders
    private String typeName;

    @Column(name = "TABLE_NAME") //PRODUCT_ORDERS
    private String tableName;

}
