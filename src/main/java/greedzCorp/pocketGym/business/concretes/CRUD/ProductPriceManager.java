package greedzCorp.pocketGym.business.concretes.CRUD;

import greedzCorp.pocketGym.business.abstracts.CRUD.ProductPriceService;
import greedzCorp.pocketGym.business.constants.BusinessMessages;
import greedzCorp.pocketGym.business.requests.ProductPriceRequest;
import greedzCorp.pocketGym.business.responses.ProductPriceResponse;
import greedzCorp.pocketGym.core.utilities.mapping.ModelMapperService;
import greedzCorp.pocketGym.core.utilities.results.*;
import greedzCorp.pocketGym.dataAccess.ProductPriceRepository;
import greedzCorp.pocketGym.entities.ProductPriceEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductPriceManager implements ProductPriceService {
    private ProductPriceRepository productPriceRepository;
    private ModelMapperService modelMapperService;

    public ProductPriceManager(ProductPriceRepository productPriceRepository, ModelMapperService modelMapperService) {
        this.productPriceRepository = productPriceRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<ProductPriceResponse>> findByProductIdAndPriceAndIsActv(ProductPriceRequest request) {
        List<ProductPriceEntity> result = this.productPriceRepository.findByProductIdAndPriceAndIsActv(request.getProductId(), request.getPrice(), 1);
        List<ProductPriceResponse> response = result.stream()
                .map(productPriceEntity -> this.modelMapperService.forDto()
                        .map(productPriceEntity, ProductPriceResponse.class))
                .collect(Collectors.toList());
        if (Objects.nonNull(response))return new SuccessDataResult<>(response);
        return new ErrorDataResult<>(BusinessMessages.productPriceMessages.PRODUCT_PRICE_NOT_FOUND.getMessage());
    }

    @Override
    public Result add(ProductPriceRequest request) {
        ProductPriceEntity productPriceEntity = this.modelMapperService.forRequest()
                .map(request, ProductPriceEntity.class);

        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        productPriceEntity.setCreateDate(formattedDate);
        this.productPriceRepository.save(productPriceEntity);
        if (Objects.nonNull(productPriceEntity)){
            return new SuccessResult(BusinessMessages.productPriceMessages.PRODUCT_PRICE_ADDED.getMessage());
        }
        return new ErrorResult(BusinessMessages.productPriceMessages.PRODUCT_PRICE_NOT_ADDED.getMessage());
    }

    @Override
    public Result update(ProductPriceRequest request) {
        ProductPriceEntity productPriceEntity = this.modelMapperService.forRequest()
                .map(request, ProductPriceEntity.class);
        this.productPriceRepository.save(productPriceEntity);
        if(Objects.nonNull(productPriceEntity)) {
            return new SuccessResult(BusinessMessages.productPriceMessages.PRODUCT_PRICE_UPDATED.getMessage());
        }
        return new ErrorResult(BusinessMessages.productPriceMessages.PRODUCT_PRICE_NOT_UPDATED.getMessage());
    }

    @Override
    public Result delete(Long id) {
        this.productPriceRepository.deleteById(Math.toIntExact(id));
        if (Objects.nonNull(id)){
            return new SuccessResult(BusinessMessages.productPriceMessages.PRODUCT_PRICE_DELETED.getMessage());
        }
        return new ErrorResult(BusinessMessages.productPriceMessages.PRODUCT_PRICE_NOT_DELETED.getMessage());
    }
}
