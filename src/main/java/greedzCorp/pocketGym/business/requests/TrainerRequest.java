package greedzCorp.pocketGym.business.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerRequest {

    @JsonIgnore
    private Long id;
    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String mobilePhone;
    private String gymName;
    private String comment;
    private Long custId;
    private Long experiments;
    private String createDate;
    private int isActv;

}
