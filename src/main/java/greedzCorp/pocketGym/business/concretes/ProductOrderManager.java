package greedzCorp.pocketGym.business.concretes;

import greedzCorp.pocketGym.business.abstracts.ProductOrderService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.requests.ProductOrderRequest;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.ErrorResult;
import greedzCorp.pocketGym.core.utilities.results.Result;
import greedzCorp.pocketGym.core.utilities.results.SuccessResult;
import greedzCorp.pocketGym.dataAccess.ProductOrderDao;
import greedzCorp.pocketGym.dataAccess.ProductPriceDao;
import greedzCorp.pocketGym.entities.ProductOrderEntity;
import greedzCorp.pocketGym.entities.ProductPriceEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class ProductOrderManager implements ProductOrderService {

    private ProductOrderDao productOrderDao;
    private ModelMapperService modelMapperService;

    public ProductOrderManager(ProductOrderDao productOrderDao, ModelMapperService modelMapperService) {
        this.productOrderDao = productOrderDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(ProductOrderRequest request) {
        ProductOrderEntity productOrderEntity = this.modelMapperService.forRequest()
                .map(request, ProductOrderEntity.class);

        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        productOrderEntity.setCreateDate(formattedDate);
        this.productOrderDao.save(productOrderEntity);
        if (Objects.nonNull(productOrderEntity)){
            return new SuccessResult(BusinessMessages.productOrderMessages.PRODUCT_ORDER_CREATED.getMessage());
        }

        return new ErrorResult(BusinessMessages.productOrderMessages.PRODUCT_ORDER_NOT_CREATED.getMessage());
    }

}
