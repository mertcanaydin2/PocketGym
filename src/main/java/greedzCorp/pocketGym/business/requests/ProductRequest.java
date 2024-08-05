package greedzCorp.pocketGym.business.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @JsonIgnore
    private Long id;
    private String productName;
    private String dataType;
    private Long dataTypeId;
    private Long stock;
    private Long totalStock;
    private String price;
}
