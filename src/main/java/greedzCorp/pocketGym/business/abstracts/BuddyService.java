package greedzCorp.pocketGym.business.abstracts;

import greedzCorp.pocketGym.business.requests.BuddyRequest;
import greedzCorp.pocketGym.business.responses.BuddyResponse;
import greedzCorp.pocketGym.core.utilities.results.DataResult;
import greedzCorp.pocketGym.core.utilities.results.Result;

import java.util.List;

public interface BuddyService {

    DataResult<List<BuddyResponse>> findRandomBuddy(BuddyRequest request); //buddy arayan kişinin id'si

    Result saveMatchedBuddy(BuddyRequest request);

    Result add(BuddyRequest request);
}
