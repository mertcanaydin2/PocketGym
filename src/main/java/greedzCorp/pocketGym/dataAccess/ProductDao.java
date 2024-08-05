package greedzCorp.pocketGym.dataAccess;

import greedzCorp.pocketGym.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Integer> {
}
