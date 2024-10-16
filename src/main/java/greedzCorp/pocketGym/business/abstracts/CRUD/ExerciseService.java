package greedzCorp.pocketGym.business.abstracts.CRUD;

import greedzCorp.pocketGym.business.requests.ExerciseRequest;
import greedzCorp.pocketGym.business.responses.ExerciseResponse;
import greedzCorp.pocketGym.core.utilities.results.DataResult;
import greedzCorp.pocketGym.core.utilities.results.Result;

import java.util.List;

public interface ExerciseService {

    DataResult<List<ExerciseResponse>> getAll();

    DataResult<List<ExerciseResponse>> getAllByMuscleGroups(String muscleGroup);

    Result add(ExerciseRequest request);

    Result update(ExerciseRequest request);

    Result delete(Long id);
}
