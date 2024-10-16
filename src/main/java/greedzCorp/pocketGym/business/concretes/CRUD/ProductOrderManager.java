package greedzCorp.pocketGym.business.concretes.CRUD;

import greedzCorp.pocketGym.business.abstracts.CRUD.ProductOrderService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.requests.ProductOrderRequest;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.ErrorResult;
import greedzCorp.pocketGym.core.utilities.results.Result;
import greedzCorp.pocketGym.core.utilities.results.SuccessResult;
import greedzCorp.pocketGym.dataAccess.ProductOrderRepository;
import greedzCorp.pocketGym.entities.ProductOrderEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class ProductOrderManager implements ProductOrderService {

    private ProductOrderRepository productOrderRepository;
    private ModelMapperService modelMapperService;

    public ProductOrderManager(ProductOrderRepository productOrderRepository, ModelMapperService modelMapperService) {
        this.productOrderRepository = productOrderRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(ProductOrderRequest request) {
        ProductOrderEntity productOrderEntity = this.modelMapperService.forRequest()
                .map(request, ProductOrderEntity.class);

        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        productOrderEntity.setCreateDate(formattedDate);
        this.productOrderRepository.save(productOrderEntity);
        if (Objects.nonNull(productOrderEntity)){
            return new SuccessResult(BusinessMessages.productOrderMessages.PRODUCT_ORDER_CREATED.getMessage());
        }

        return new ErrorResult(BusinessMessages.productOrderMessages.PRODUCT_ORDER_NOT_CREATED.getMessage());
    }

}
