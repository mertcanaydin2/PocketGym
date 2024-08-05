package greedzCorp.pocketGym.business.abstracts;

import greedzCorp.pocketGym.business.requests.PartyRequest;
import greedzCorp.pocketGym.core.utilities.results.Result;

public interface PartyService {

    Result add(PartyRequest request);

}
