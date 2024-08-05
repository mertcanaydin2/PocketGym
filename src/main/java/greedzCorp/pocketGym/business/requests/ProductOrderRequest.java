package greedzCorp.pocketGym.business.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderRequest {

    @JsonIgnore
    private Long id;
    private String productName;
    private Long productId;
    private String dataType;
    private String price;
    private String customerName;
    private Long customerId;
    private Long orderState;
    private String orderType;
}
