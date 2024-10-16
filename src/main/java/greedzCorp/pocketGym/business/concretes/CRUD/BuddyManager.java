package greedzCorp.pocketGym.business.concretes.CRUD;

import greedzCorp.pocketGym.business.abstracts.CRUD.BuddyService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.constants.StateEnums;
import greedzCorp.pocketGym.business.requests.BuddyRequest;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.ErrorResult;
import greedzCorp.pocketGym.core.utilities.results.Result;
import greedzCorp.pocketGym.core.utilities.results.SuccessResult;
import greedzCorp.pocketGym.dataAccess.BuddyRepository;
import greedzCorp.pocketGym.entities.BuddyEntity;
import org.springframework.stereotype.Service;

@Service
public class BuddyManager implements BuddyService {

    private BuddyRepository buddyRepository;
    private ModelMapperService modelMapperService;

    public BuddyManager(BuddyRepository buddyRepository, ModelMapperService modelMapperService) {
        this.buddyRepository = buddyRepository;
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
            this.buddyRepository.save(buddyEntity);
            return new SuccessResult(BusinessMessages.buddyMessages.BUDDY_CREATED.getMessage());
        } catch (Exception e) {
            return new ErrorResult(BusinessMessages.buddyMessages.BUDDY_NOT_CREATED.getMessage());
        }
    }

    @Override
    public Result update(BuddyRequest request) {
        try {
            BuddyEntity buddyEntity = this.modelMapperService.forRequest()
                    .map(request, BuddyEntity.class);

            this.buddyRepository.save(buddyEntity);
            return new SuccessResult(BusinessMessages.buddyMessages.BUDDY_UPDATED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResult(BusinessMessages.buddyMessages.BUDDY_NOT_UPDATED.getMessage());
        }
    }

    @Override
    public Result delete(BuddyRequest request) {
        if (!checkBuddyIsExists(request.getCustId())) {
            return new ErrorResult(BusinessMessages.buddyMessages.BUDDY_NOT_FOUND.getMessage());
        }
        try {
            Long buddyId = buddyRepository.findAllByCustIdAndIsActv(request.getCustId(), 1).get(0).getId();
            this.buddyRepository.deleteById(Math.toIntExact(buddyId));
            return new SuccessResult(BusinessMessages.buddyMessages.BUDDY_DELETED.getMessage());
        } catch (Exception e) {
            return new ErrorResult(BusinessMessages.buddyMessages.BUDDY_NOT_DELETED.getMessage());
        }
    }

    private boolean checkBuddyIsExists(Long custId) {
        boolean result;
        try {
            if (buddyRepository.existsByCustIdAndIsActv(custId, 1)) {
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
