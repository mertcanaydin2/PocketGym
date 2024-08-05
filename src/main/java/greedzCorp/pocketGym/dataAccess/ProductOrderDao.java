package greedzCorp.pocketGym.dataAccess;

import greedzCorp.pocketGym.entities.ProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderDao extends JpaRepository<ProductOrderEntity, Integer> {
}
