package greedzCorp.pocketGym.business.abstracts;

import greedzCorp.pocketGym.business.requests.BuddyRequest;
import greedzCorp.pocketGym.core.utilities.results.Result;

public interface BuddyService {
    Result add(BuddyRequest request);
}
