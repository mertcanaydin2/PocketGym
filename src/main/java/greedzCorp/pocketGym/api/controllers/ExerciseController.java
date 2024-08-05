package greedzCorp.pocketGym.api.controllers;

import greedzCorp.pocketGym.business.abstracts.ExerciseService;
import greedzCorp.pocketGym.business.requests.ExerciseRequest;
import greedzCorp.pocketGym.business.responses.ExerciseResponse;
import greedzCorp.pocketGym.core.utilities.results.DataResult;
import greedzCorp.pocketGym.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/getall")
    public DataResult<List<ExerciseResponse>> getAll() {
        return this.exerciseService.getAll();
    }

    @GetMapping("/getAllByMuscleGroups")
    public DataResult<List<ExerciseResponse>> getAllByMuscleGroups(@RequestBody String muscleGroups) {
        return this.exerciseService.getAllByMuscleGroups(muscleGroups);
    }

    @PostMapping("/add")
    public Result add(@RequestBody ExerciseRequest exerciseRequest) {
        return this.exerciseService.add(exerciseRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody ExerciseRequest exerciseRequest) {
        return this.exerciseService.update(exerciseRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Long id) {
        return this.exerciseService.delete(id);
    }
}
