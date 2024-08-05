package greedzCorp.pocketGym.business.abstracts;

import greedzCorp.pocketGym.business.requests.ProductOrderRequest;
import greedzCorp.pocketGym.core.utilities.results.Result;

public interface ProductOrderService {

    Result add (ProductOrderRequest productOrderRequest);
}
