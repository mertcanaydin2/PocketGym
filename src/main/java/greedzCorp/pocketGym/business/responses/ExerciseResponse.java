package greedzCorp.pocketGym.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseResponse {
    private String exerciseName;
    private String primaryMuscleGroup;
    private String secondaryMuscleGroup;
    private String thirdMuscleGroup;
    private String fourthMuscleGroup;
    private String fifthMuscleGroup;

}
