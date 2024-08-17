package greedzCorp.pocketGym.business.abstracts;

import greedzCorp.pocketGym.business.requests.BuddyRequest;
import greedzCorp.pocketGym.business.responses.BuddyResponse;
import greedzCorp.pocketGym.core.utilities.results.DataResult;

import java.util.List;

public interface FindBuddyService {

    DataResult<List<BuddyResponse>> findRandomBuddy(BuddyRequest request); //buddy arayan kişinin id'si

}
