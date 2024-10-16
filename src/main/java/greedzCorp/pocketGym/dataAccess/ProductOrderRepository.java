package greedzCorp.pocketGym.dataAccess;

import greedzCorp.pocketGym.entities.ProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, Integer> {
}
