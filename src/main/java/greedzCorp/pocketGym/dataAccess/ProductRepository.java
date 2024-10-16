package greedzCorp.pocketGym.dataAccess;

import greedzCorp.pocketGym.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface eProductRepository extends JpaRepository<ProductEntity, Integer> {
}
