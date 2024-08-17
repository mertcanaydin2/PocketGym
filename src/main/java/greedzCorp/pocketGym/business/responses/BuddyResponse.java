package greedzCorp.pocketGym.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuddyResponse {
    private long custId;

    private String name;

    private String surname;

    private long relatedBuddyId;

    private Long provinceId;
}
