package greedzCorp.pocketGym.business.concretes.CRUD;

import greedzCorp.pocketGym.business.abstracts.BuddyService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.constants.StateEnums;
import greedzCorp.pocketGym.business.requests.BuddyRequest;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.*;
import greedzCorp.pocketGym.dataAccess.BuddyDao;
import greedzCorp.pocketGym.entities.BuddyEntity;
import org.springframework.stereotype.Service;

@Service
public class BuddyManager implements BuddyService {

    private BuddyDao buddyDao;
    private ModelMapperService modelMapperService;

    public BuddyManager(BuddyDao buddyDao, ModelMapperService modelMapperService) {
        this.buddyDao = buddyDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(BuddyRequest request) {
        if (checkBuddyIsExists(request.getCustId())) {
            return new ErrorResult(BusinessMessages.buddyMessages.BUDDY_IS_ALREADY_EXISTS.getMessage());
        }

        try {
            BuddyEntity buddyEntity = this.modelMapperService.forRequest()
                    .map(request, BuddyEntity.class);

            buddyEntity.setStId(StateEnums.BuddyStates.ACTV.getStId());
            buddyEntity.setProvinceId(request.getProvinceId());
            this.buddyDao.save(buddyEntity);
            return new SuccessResult(BusinessMessages.buddyMessages.BUDDY_CREATED.getMessage());
        } catch (Exception e) {
            return new ErrorResult(BusinessMessages.buddyMessages.BUDDY_NOT_CREATED.getMessage());
        }
    }

    private boolean checkBuddyIsExists(Long custId) {
        boolean result;
        try {
            if (buddyDao.existsByCustIdAndIsActv(custId, 1)) {
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
