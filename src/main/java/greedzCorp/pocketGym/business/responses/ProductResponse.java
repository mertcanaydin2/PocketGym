package greedzCorp.pocketGym.business.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String productName;
    private String dataType;
    private Long dataTypeId;
    private Long stock;
    private Long totalStock;
    private String price;
}
