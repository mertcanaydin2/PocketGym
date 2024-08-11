package greedzCorp.pocketGym.business.concretes;

import greedzCorp.pocketGym.business.abstracts.ExerciseService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.requests.ExerciseRequest;
import greedzCorp.pocketGym.business.responses.ExerciseResponse;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.*;
import greedzCorp.pocketGym.dataAccess.ExerciseDao;
import greedzCorp.pocketGym.entities.ExerciseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class ExerciseManager implements ExerciseService {
    private ExerciseDao exerciseDao;
    private ModelMapperService modelMapperService;

    public ExerciseManager(ExerciseDao exerciseDao, ModelMapperService modelMapperService) {
        this.exerciseDao = exerciseDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<ExerciseResponse>> getAll() {
        List<ExerciseEntity> exerciseEntities = this.exerciseDao.findAll();
        List<ExerciseResponse> response = exerciseEntities.stream()
                .map(exerciseEntity -> this.modelMapperService.forDto()
                        .map(exerciseEntity, ExerciseResponse.class))
                .toList();
        if (Objects.nonNull(response) && !response.isEmpty()) {
            return new SuccessDataResult<>(response);
        } else {
            return new ErrorDataResult<>(BusinessMessages.exerciseMessages.EXERCISE_NOT_FOUND.getMessage());
        }

    }

    @Override
    public Result add(ExerciseRequest request) {
        if (checkExerciseIsExists(request.getExerciseName()))
            return new ErrorResult(BusinessMessages.exerciseMessages.EXERCISE_IS_ALREADY_EXISTS.getMessage());

        try {
            ExerciseEntity exerciseEntity = this.modelMapperService.forRequest()
                    .map(request, ExerciseEntity.class);

            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
            exerciseEntity.setCreateDate(formattedDate);
            this.exerciseDao.save(exerciseEntity);

            return new SuccessResult(BusinessMessages.exerciseMessages.EXERCISE_CREATED.getMessage());
        } catch (Exception e) {
            return new ErrorResult(BusinessMessages.exerciseMessages.EXERCISE_NOT_CREATED.getMessage());
        }
    }

    @Override
    public Result update(ExerciseRequest request) {
        ExerciseEntity exerciseEntity = this.modelMapperService.forRequest()
                .map(request, ExerciseEntity.class);

        this.exerciseDao.save(exerciseEntity);
        if (Objects.nonNull(exerciseEntity))
            return new SuccessResult(BusinessMessages.exerciseMessages.EXERCISE_CREATED.getMessage());
        return new ErrorResult(BusinessMessages.exerciseMessages.EXERCISE_NOT_CREATED.getMessage());
    }

    @Override
    public Result delete(Long id) {
        this.exerciseDao.deleteById(Integer.valueOf(Math.toIntExact(id)));
        if (Objects.nonNull(id))
            return new SuccessResult(BusinessMessages.exerciseMessages.EXERCISE_DELETED.getMessage());
        return new ErrorResult(BusinessMessages.exerciseMessages.EXERCISE_NOT_DELETED.getMessage());
    }

    public boolean checkExerciseIsExists(String exerciseName) {
        boolean result;
        try {
            if (exerciseDao.existsByExerciseNameIgnoreCaseAndIsActv(exerciseName, true)) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    } 

    @Override
    public DataResult<List<ExerciseResponse>> getAllByMuscleGroups(String muscleGroup) {
        List<ExerciseEntity> result = this.exerciseDao.getAllByPrimaryMuscleGroup(muscleGroup);
        List<ExerciseResponse> response = result.stream()
                .map(exerciseEntity -> this.modelMapperService.forDto()
                        .map(exerciseEntity, ExerciseResponse.class))
                .toList();
        if (Objects.nonNull(response)) return new SuccessDataResult<>(response);
        return new ErrorDataResult<>(BusinessMessages.exerciseMessages.EXERCISE_NOT_FOUND.getMessage());
    }
}
