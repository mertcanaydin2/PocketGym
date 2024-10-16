package greedzCorp.pocketGym.api.controllers;

import greedzCorp.pocketGym.business.abstracts.CRUD.ProductPriceService;
import greedzCorp.pocketGym.business.requests.ProductPriceRequest;
import greedzCorp.pocketGym.business.responses.ProductPriceResponse;
import greedzCorp.pocketGym.core.utilities.results.DataResult;
import greedzCorp.pocketGym.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price")
public class ProductPriceController {
    private ProductPriceService productPriceService;

    public ProductPriceController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody ProductPriceRequest request) {
        return this.productPriceService.add(request);
    }

    @PostMapping("/update")
    public Result update(@RequestBody ProductPriceRequest request) {
        return this.productPriceService.update(request);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Long id) {
        return this.productPriceService.delete(id);
    }

    @GetMapping("/findByProductIdAndPriceAndIsActv")
    public DataResult<List<ProductPriceResponse>> findByProductIdAndPriceAndIsActv(@RequestBody ProductPriceRequest request) {
        return this.productPriceService.findByProductIdAndPriceAndIsActv(request);
    }
}
