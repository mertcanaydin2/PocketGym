package greedzCorp.pocketGym.business.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderResponse {

    private String productName;
    private Long productId;
    private String dataType;
    private String price;
    private String customerName;
    private Long customerId;
    private Long orderState;
    private String orderType;
}
