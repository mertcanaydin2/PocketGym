package greedzCorp.pocketGym.business.concretes;

import greedzCorp.pocketGym.business.abstracts.BuddyService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.constants.StateEnums;
import greedzCorp.pocketGym.business.requests.BuddyRequest;
import greedzCorp.pocketGym.business.responses.BuddyResponse;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.*;
import greedzCorp.pocketGym.dataAccess.BuddyDao;
import greedzCorp.pocketGym.entities.BuddyEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BuddyManager implements BuddyService {

    private BuddyDao buddyDao;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<BuddyResponse>> findRandomBuddy(BuddyRequest request) {
        Long buddyId = buddyDao.findRandomBuddy(StateEnums.BuddyStates.ACTV.getStId());
        List<BuddyEntity> buddies =  buddyDao.findAllByIdAndIsActv(buddyId, true);
        List<BuddyResponse> response = buddies.stream()
                .map(buddyEntity -> this.modelMapperService.forDto()
                        .map(buddyEntity, BuddyResponse.class))
                .toList();

        if(Objects.nonNull(response)){
            return new SuccessDataResult<>(response);
        }
        return null;
    }

    @Override
    public Result saveMatchedBuddy(BuddyRequest request) {

        if (!checkBuddyIsSelectable(request.getId())){
            return new ErrorResult(BusinessMessages.buddyMessages.BUDDY_IS_NOT_SELECTABLE.getMessage());
        }

        BuddyEntity buddyEntity = this.modelMapperService.forRequest()
                .map(request, BuddyEntity.class);

        buddyEntity.setRelatedBuddyId(request.getRelatedBuddyId());
        buddyEntity.setStId(StateEnums.BuddyStates.MATCHED.getStId());
        this.buddyDao.save(buddyEntity);
        return null;
    }

    @Override
    public Result add(BuddyRequest request) {
        if (checkBuddyIsExists(request.getCustId())) {
            return new ErrorResult(BusinessMessages.buddyMessages.BUDDY_IS_ALREADY_EXISTS.getMessage());
        }

        try {
            BuddyEntity buddyEntity = this.modelMapperService.forRequest()
                    .map(request, BuddyEntity.class);

            this.buddyDao.save(buddyEntity);
            return new SuccessResult(BusinessMessages.buddyMessages.BUDDY_CREATED.getMessage());
        } catch (Exception e) {
            return new ErrorResult(BusinessMessages.buddyMessages.BUDDY_NOT_CREATED.getMessage());
        }
    }

    private boolean checkBuddyIsSelectable(Long buddyId) {
        BuddyEntity buddyEntity = buddyDao.findBuddyEntitiesByIdAndIsActv(buddyId, true);
        if (StateEnums.BuddyStates.ACTV.getStId().equals(buddyEntity.getStId())){
            return true;
        }
        return false;
    }

    private boolean checkBuddyIsExists(Long custId) {
        boolean result;
        try {
            if (buddyDao.existsByCustIdAndisActv(custId, true)) {
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
}
