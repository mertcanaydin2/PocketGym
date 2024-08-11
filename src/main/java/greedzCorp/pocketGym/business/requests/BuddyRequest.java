package greedzCorp.pocketGym.business.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuddyRequest {

    @JsonIgnore
    private long id;

    private long custId;

    private String name;

    private String surname;

    private long relatedBuddyId;
}
