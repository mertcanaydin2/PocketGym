package greedzCorp.pocketGym.business.concretes.CRUD;

import greedzCorp.pocketGym.business.abstracts.PartyService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.requests.PartyRequest;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.ErrorResult;
import greedzCorp.pocketGym.core.utilities.results.Result;
import greedzCorp.pocketGym.core.utilities.results.SuccessResult;
import greedzCorp.pocketGym.dataAccess.PartyDao;
import greedzCorp.pocketGym.entities.PartyEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PartyManager implements PartyService {

    private PartyDao partyDao;
    private ModelMapperService modelMapperService;

    public PartyManager(PartyDao partyDao, ModelMapperService modelMapperService) {
        this.partyDao = partyDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(PartyRequest request) {
        if (checkMobilePhoneIsExists(request.getMobilePhone(),request.getPartyState()))
            return new ErrorResult(BusinessMessages.partyMessages.PARTY_USER_IS_ALREADY_EXISTS.getMessage());

        try {
            PartyEntity partyEntity = this.modelMapperService.forRequest()
                    .map(request, PartyEntity.class);

            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
            partyEntity.setCreateDate(formattedDate);
            partyEntity.setPartyType("Ind");
            partyEntity.setPartyState(1L);
            this.partyDao.save(partyEntity);

            return new SuccessResult(BusinessMessages.partyMessages.PARTY_USER_CREATED.getMessage());
        } catch (Exception e) {
            return new ErrorResult(BusinessMessages.partyMessages.PARTY_USER_NOT_CREATED.getMessage());
        }
    }

    private boolean checkMobilePhoneIsExists(String mobilePhone, Long stId) {
        try {
            if (partyDao.existsByMobilePhoneAndPartyState(mobilePhone, stId)) {
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
