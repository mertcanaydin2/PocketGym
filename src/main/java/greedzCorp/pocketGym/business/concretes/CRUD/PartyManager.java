package greedzCorp.pocketGym.business.concretes.CRUD;

import greedzCorp.pocketGym.business.abstracts.CRUD.PartyService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.requests.PartyRequest;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.ErrorResult;
import greedzCorp.pocketGym.core.utilities.results.Result;
import greedzCorp.pocketGym.core.utilities.results.SuccessResult;
import greedzCorp.pocketGym.dataAccess.PartyRepository;
import greedzCorp.pocketGym.entities.PartyEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PartyManager implements PartyService {

    private PartyRepository partyRepository;
    private ModelMapperService modelMapperService;

    public PartyManager(PartyRepository partyRepository, ModelMapperService modelMapperService) {
        this.partyRepository = partyRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(PartyRequest request) {
        if (checkMobilePhoneIsExists(request.getMobilePhone(),request.getPartyState()))
            return new ErrorResult(BusinessMessages.partyMessages.PARTY_USER_IS_ALREADY_EXISTS.getMessage());

        try {
            PartyEntity partyEntity = this.modelMapperService.forRequest()
                    .map(request, PartyEntity.class);

            partyEntity.setPartyType("Ind");
            partyEntity.setPartyState(1L);
            this.partyRepository.save(partyEntity);

            return new SuccessResult(BusinessMessages.partyMessages.PARTY_USER_CREATED.getMessage());
        } catch (Exception e) {
            return new ErrorResult(BusinessMessages.partyMessages.PARTY_USER_NOT_CREATED.getMessage());
        }
    }

    @Override
    public Result update(PartyRequest request) {
        if(!checkMobilePhoneIsExists(request.getMobilePhone(),request.getPartyState())){
            return new ErrorResult(BusinessMessages.partyMessages.PARTY_USER_NOT_FOUND.getMessage());
        }

        try {
            PartyEntity partyEntity = this.modelMapperService.forRequest()
                    .map(request, PartyEntity.class);

            partyEntity.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")));
            this.partyRepository.save(partyEntity);
            return new SuccessResult(BusinessMessages.partyMessages.PARTY_USER_UPDATED.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorResult(BusinessMessages.partyMessages.PARTY_USER_NOT_UPDATED.getMessage());
        }
    }

    @Override
    public Result delete(Long id) {
        return null;
    }

    private boolean checkMobilePhoneIsExists(String mobilePhone, Long stId) {
        try {
            if (partyRepository.existsByMobilePhoneAndPartyState(mobilePhone, stId)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
