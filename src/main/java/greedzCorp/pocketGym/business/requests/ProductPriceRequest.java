package greedzCorp.pocketGym.business.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceRequest {

    @JsonIgnore
    private Long id;
    private Long productId;
    private String price;
    private String priceType;
    private String createDate;
    private int isActv;
}
