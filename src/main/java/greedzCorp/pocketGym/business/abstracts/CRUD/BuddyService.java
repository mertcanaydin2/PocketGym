package greedzCorp.pocketGym.business.abstracts.CRUD;

import greedzCorp.pocketGym.business.requests.BuddyRequest;
import greedzCorp.pocketGym.core.utilities.results.Result;

public interface BuddyService {
    Result add(BuddyRequest request);

    Result update(BuddyRequest request);

    Result delete(BuddyRequest request);
}
