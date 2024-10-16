package greedzCorp.pocketGym.business.concretes.CRUD;

import greedzCorp.pocketGym.business.abstracts.CRUD.ExerciseService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.requests.ExerciseRequest;
import greedzCorp.pocketGym.business.responses.ExerciseResponse;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.*;
import greedzCorp.pocketGym.dataAccess.ExerciseRepository;
import greedzCorp.pocketGym.entities.ExerciseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class ExerciseManager implements ExerciseService {
    private ExerciseRepository exerciseRepository;
    private ModelMapperService modelMapperService;

    public ExerciseManager(ExerciseRepository exerciseRepository, ModelMapperService modelMapperService) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<ExerciseResponse>> getAll() {
        List<ExerciseEntity> exerciseEntities = this.exerciseRepository.findAll();
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
            exerciseEntity.setIsActv(1);
            this.exerciseRepository.save(exerciseEntity);

            return new SuccessResult(BusinessMessages.exerciseMessages.EXERCISE_CREATED.getMessage());
        } catch (Exception e) {
            return new ErrorResult(BusinessMessages.exerciseMessages.EXERCISE_NOT_CREATED.getMessage());
        }
    }

    @Override
    public Result update(ExerciseRequest request) {
        try {
            ExerciseEntity exerciseEntity = this.modelMapperService.forRequest()
                    .map(request, ExerciseEntity.class);

            this.exerciseRepository.save(exerciseEntity);
            return new SuccessResult(BusinessMessages.exerciseMessages.EXERCISE_UPDATED.getMessage());
        } catch (Exception e) {
            return new ErrorResult(BusinessMessages.exerciseMessages.EXERCISE_NOT_UPDATED.getMessage());
        }
    }

    @Override
    public Result delete(Long id) {
        try {
            this.exerciseRepository.deleteById(Integer.valueOf(Math.toIntExact(id)));
            return new SuccessResult(BusinessMessages.exerciseMessages.EXERCISE_DELETED.getMessage());

        } catch (Exception e) {
            return new ErrorResult(BusinessMessages.exerciseMessages.EXERCISE_NOT_DELETED.getMessage());
        }
    }

    public boolean checkExerciseIsExists(String exerciseName) {
        boolean result = false;
        try {
            if (exerciseRepository.existsByExerciseNameIgnoreCaseAndIsActv(exerciseName, 1)) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public DataResult<List<ExerciseResponse>> getAllByMuscleGroups(String muscleGroup) {
        List<ExerciseEntity> result = this.exerciseRepository.getAllByPrimaryMuscleGroup(muscleGroup);
        List<ExerciseResponse> response = result.stream()
                .map(exerciseEntity -> this.modelMapperService.forDto()
                        .map(exerciseEntity, ExerciseResponse.class))
                .toList();
        if (Objects.nonNull(response)) return new SuccessDataResult<>(response);
        return new ErrorDataResult<>(BusinessMessages.exerciseMessages.EXERCISE_NOT_FOUND.getMessage());
    }
}
