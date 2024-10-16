package greedzCorp.pocketGym.dataAccess;

import greedzCorp.pocketGym.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Integer> {

    List<ExerciseEntity> getAllById(Long exerciseId);

    List<ExerciseEntity> getAllByPrimaryMuscleGroup(String muscleGroup);

    boolean existsByExerciseNameIgnoreCaseAndIsActv(String exerciseName, int isActv);
}
