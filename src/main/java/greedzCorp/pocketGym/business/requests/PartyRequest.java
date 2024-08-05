package greedzCorp.pocketGym.business.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartyRequest {

    @JsonIgnore
    private Long id;
    private String fullName;
    private String nationality;
    private String natId;
    private String mobilePhone;
    private String gender;
    private String age;
    private String gymName;
    private String partyType;
    private String address;
    private String cityName;
    private String createDate;
    private Long partyState;
    private Long wallet;
    private String password;
}
