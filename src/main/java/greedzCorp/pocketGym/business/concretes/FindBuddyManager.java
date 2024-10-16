package greedzCorp.pocketGym.business.concretes;

import greedzCorp.pocketGym.business.abstracts.FindBuddyService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.constants.StateEnums;
import greedzCorp.pocketGym.business.requests.BuddyRequest;
import greedzCorp.pocketGym.business.responses.BuddyResponse;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.DataResult;
import greedzCorp.pocketGym.core.utilities.results.ErrorResult;
import greedzCorp.pocketGym.core.utilities.results.Result;
import greedzCorp.pocketGym.core.utilities.results.SuccessDataResult;
import greedzCorp.pocketGym.dataAccess.BuddyRepository;
import greedzCorp.pocketGym.entities.BuddyEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FindBuddyManager implements FindBuddyService {

    private BuddyRepository buddyRepository;
    private ModelMapperService modelMapperService;

    public FindBuddyManager(BuddyRepository buddyRepository, ModelMapperService modelMapperService) {
        this.buddyRepository = buddyRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<BuddyResponse>> findRandomBuddy(BuddyRequest request) {
        Long provinceId = buddyRepository.findProvinceIdByCustId(request.getCustId());//işlem yapan user
        Long buddyId = buddyRepository.findRandomBuddy(StateEnums.BuddyStates.ACTV.getStId(), provinceId, request.getCustId());
        List<BuddyEntity> buddies = buddyRepository.findAllById(buddyId);
        List<BuddyResponse> response = buddies.stream()
                .map(buddyEntity -> this.modelMapperService.forDto()
                        .map(buddyEntity, BuddyResponse.class))
                .toList();

        if (Objects.nonNull(response)) {
            return new SuccessDataResult<>(response);
        }
        return null;
    }

    public Result saveMatchedBuddy(BuddyRequest request) {

        if (!checkBuddyIsSelectable(request.getId())){
            return new ErrorResult(BusinessMessages.buddyMessages.BUDDY_IS_NOT_SELECTABLE.getMessage());
        }

        BuddyEntity buddyEntity = this.modelMapperService.forRequest()
                .map(request, BuddyEntity.class);

        buddyEntity.setRelatedBuddyId(request.getRelatedBuddyId());
        buddyEntity.setStId(StateEnums.BuddyStates.MATCHED.getStId());
        this.buddyRepository.save(buddyEntity);
        return null;
    }

    private boolean checkBuddyIsSelectable(Long buddyId) {
        BuddyEntity buddyEntity = buddyRepository.findBuddyEntitiesByIdAndIsActv(buddyId, 1);
        if (StateEnums.BuddyStates.ACTV.getStId().equals(buddyEntity.getStId())){
            return true;
        }
        return false;
    }
}
