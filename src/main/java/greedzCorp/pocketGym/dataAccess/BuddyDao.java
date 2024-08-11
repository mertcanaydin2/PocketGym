package greedzCorp.pocketGym.dataAccess;

import greedzCorp.pocketGym.entities.BuddyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuddyDao extends JpaRepository<BuddyEntity, Integer> {

    List<BuddyEntity> findAllByIdAndIsActv(Long id, boolean isActv);

    BuddyEntity findBuddyEntitiesByIdAndIsActv(Long id, boolean isActv);

    boolean existsByCustIdAndisActv(Long id, boolean isActv);

    @Query(value = "SELECT b.id FROM BUDDY b WHERE IS_ACTV = 1 AND ST_ID = :stId ORDER BY RANDOM() LIMIT 1" , nativeQuery = true)
    Long findRandomBuddy(@Param("stId") Long stId);

}
