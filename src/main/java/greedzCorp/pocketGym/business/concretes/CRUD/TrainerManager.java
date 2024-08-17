package greedzCorp.pocketGym.business.concretes.CRUD;

import greedzCorp.pocketGym.business.abstracts.TrainerService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.requests.TrainerRequest;
import greedzCorp.pocketGym.business.responses.TrainerResponse;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.*;
import greedzCorp.pocketGym.dataAccess.TrainerDao;
import greedzCorp.pocketGym.entities.TrainerEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class TrainerManager implements TrainerService {
    private TrainerDao trainerDao;
    private ModelMapperService modelMapperService;

    public TrainerManager(TrainerDao trainerDao, ModelMapperService modelMapperService) {
        this.trainerDao = trainerDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<TrainerResponse>> getAll() {
        List<TrainerEntity> trainerEntities = this.trainerDao.findAll();
        List<TrainerResponse> response = trainerEntities.stream()
                .map(trainerEntity -> this.modelMapperService.forDto()
                        .map(trainerEntity, TrainerResponse.class))
                .toList();
        if (Objects.nonNull(response)) {
            return new SuccessDataResult<>(response);
        } else {
            return new ErrorDataResult<>(BusinessMessages.trainerMessages.TRAINER_NOT_FOUND.getMessage());
        }
    }

    @Override
    public Result add(TrainerRequest request) {
        try {
            TrainerEntity trainerEntity = this.modelMapperService.forRequest()
                    .map(request, TrainerEntity.class);
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
            trainerEntity.setCreateDate(formattedDate);
            this.trainerDao.save(trainerEntity);
            return new SuccessResult(BusinessMessages.trainerMessages.TRAINER_ADDED.getMessage());
        } catch (Exception e) {
            return new ErrorResult(BusinessMessages.trainerMessages.TRAINER_NOT_ADDED.getMessage());
        }
    }

    @Override
    public Result update(TrainerRequest request) {
        TrainerEntity trainerEntity = this.modelMapperService.forRequest()
                .map(request, TrainerEntity.class);

        this.trainerDao.save(trainerEntity);
        if (Objects.nonNull(trainerEntity))
            return new SuccessResult(BusinessMessages.trainerMessages.TRAINER_UPDATED.getMessage());
        return new ErrorResult(BusinessMessages.trainerMessages.TRAINER_NOT_UPDATED.getMessage());
    }

    @Override
    public Result delete(Long id) {
        this.trainerDao.deleteById(Math.toIntExact(id));
        if (Objects.nonNull(id))
            return new SuccessResult(BusinessMessages.trainerMessages.TRAINER_DELETED.getMessage());
        return new ErrorResult(BusinessMessages.trainerMessages.TRAINER_NOT_DELETED.getMessage());
    }

    @Override
    public DataResult<List<TrainerResponse>> getAllByTrainerName(TrainerRequest request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();

        List<TrainerEntity> trainerEntities = null;
        if (Objects.nonNull(firstName) || Objects.nonNull(lastName)) {
            if (Objects.nonNull(firstName)) {
                if (Objects.nonNull(lastName)) {
                    trainerEntities = this.trainerDao.findAllByFirstNameAndLastNameAndIsActv(firstName, lastName, 1);
                } else {
                    trainerEntities = this.trainerDao.findAllByFirstNameAndIsActv(firstName, 1);
                }
            } else if (Objects.nonNull(lastName)) {
                trainerEntities = this.trainerDao.findAllByLastNameAndIsActv(lastName, 1);
            }

            List<TrainerResponse> response = trainerEntities.stream()
                    .map(trainerEntity -> this.modelMapperService.forDto()
                            .map(trainerEntity, TrainerResponse.class))
                    .toList();

            return new SuccessDataResult<>(response);
        }
        return new ErrorDataResult<>(BusinessMessages.trainerMessages.TRAINER_NOT_FOUND.getMessage());
    }
}