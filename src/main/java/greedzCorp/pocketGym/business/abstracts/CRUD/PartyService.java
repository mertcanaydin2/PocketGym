package greedzCorp.pocketGym.business.abstracts.CRUD;

import greedzCorp.pocketGym.business.requests.PartyRequest;
import greedzCorp.pocketGym.core.utilities.results.Result;

public interface PartyService {

    Result add(PartyRequest request);
    Result update(PartyRequest request);
    Result delete(Long id);

}
