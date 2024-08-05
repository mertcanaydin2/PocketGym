package greedzCorp.pocketGym.business.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseRequest {

    @JsonIgnore
    private Long id;
    private String exerciseName;
    private String primaryMuscleGroup;
    private String secondaryMuscleGroup;
    private String thirdMuscleGroup;
    private String fourthMuscleGroup;
    private String fifthMuscleGroup;
    private String createDate;
    private int isActv;

}
