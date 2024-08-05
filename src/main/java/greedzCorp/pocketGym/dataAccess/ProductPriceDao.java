package greedzCorp.pocketGym.dataAccess;

import greedzCorp.pocketGym.entities.ProductPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPriceDao extends JpaRepository<ProductPriceEntity, Integer> {
    List<ProductPriceEntity> findByProductIdAndPriceAndIsActv(Long productId, String price, int isActv);

}
