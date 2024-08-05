package greedzCorp.pocketGym.business.abstracts;

import greedzCorp.pocketGym.business.requests.TrainerRequest;
import greedzCorp.pocketGym.business.responses.TrainerResponse;
import greedzCorp.pocketGym.core.utilities.results.DataResult;
import greedzCorp.pocketGym.core.utilities.results.Result;

import java.util.List;

public interface TrainerService {

    DataResult<List<TrainerResponse>> getAll();
    Result add(TrainerRequest request);
    Result update(TrainerRequest request);
    Result delete(Long id);
    DataResult<List<TrainerResponse>> getAllByTrainerName(TrainerRequest trainerRequest);
}
