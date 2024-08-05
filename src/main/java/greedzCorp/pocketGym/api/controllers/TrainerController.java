package greedzCorp.pocketGym.api.controllers;


import greedzCorp.pocketGym.business.abstracts.TrainerService;
import greedzCorp.pocketGym.business.requests.TrainerRequest;
import greedzCorp.pocketGym.business.responses.TrainerResponse;
import greedzCorp.pocketGym.core.utilities.results.DataResult;
import greedzCorp.pocketGym.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {
    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/getall")
    public DataResult<List<TrainerResponse>> getAll(){
        return this.trainerService.getAll();
    }

    @GetMapping("/getAllByTrainerName")
    public DataResult<List<TrainerResponse>> getAllByTrainerName(@RequestBody TrainerRequest trainerRequest){
        return this.trainerService.getAllByTrainerName(trainerRequest);
    }

    @PostMapping("/add")
    public Result add(@RequestBody TrainerRequest request) {
        return this.trainerService.add(request);
    }

    @PostMapping("/update")
    public Result update(@RequestBody TrainerRequest request) {
        return this.trainerService.update(request);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Long id) {
        return this.trainerService.delete(id);
    }
}
