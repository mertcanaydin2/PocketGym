package greedzCorp.pocketGym.business.abstracts;

import greedzCorp.pocketGym.business.requests.ProductPriceRequest;
import greedzCorp.pocketGym.business.responses.ProductPriceResponse;
import greedzCorp.pocketGym.core.utilities.results.DataResult;
import greedzCorp.pocketGym.core.utilities.results.Result;

import java.util.List;

public interface ProductPriceService {
    DataResult<List<ProductPriceResponse>> findByProductIdAndPriceAndIsActv(ProductPriceRequest request);

    Result add(ProductPriceRequest request);
    Result update(ProductPriceRequest request);
    Result delete(Long id);
}
