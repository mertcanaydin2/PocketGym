package greedzCorp.pocketGym.business.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerResponse {
    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String mobilePhone;
    private String gymName;
    private String comment;
    private Long experiments;
    private Long custId;

}
