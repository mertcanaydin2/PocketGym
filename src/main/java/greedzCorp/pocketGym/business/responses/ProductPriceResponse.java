package greedzCorp.pocketGym.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceResponse {
    private Long productId;
    private String price;
    private String priceType;
    private String createDate;
}
