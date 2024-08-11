package greedzCorp.pocketGym.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EXERCISES")
public class ExerciseEntity extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "EXERCISE_NAME")
    private String exerciseName;

    @Column(name = "PRIMARY_MUSCLE_GROUP")
    private String primaryMuscleGroup;

    @Column(name = "SECONDARY_MUSCLE_GROUP")
    private String secondaryMuscleGroup;

    @Column(name = "THIRD_MUSCLE_GROUP")
    private String thirdMuscleGroup;

    @Column(name = "FOURTH_MUSCLE_GROUP")
    private String fourthMuscleGroup;

    @Column(name = "FIFTH_MUSCLE_GROUP")
    private String fifthMuscleGroup;
}
