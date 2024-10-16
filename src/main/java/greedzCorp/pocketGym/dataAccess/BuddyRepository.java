package greedzCorp.pocketGym.dataAccess;

import greedzCorp.pocketGym.entities.BuddyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuddyRepository extends JpaRepository<BuddyEntity, Integer> {

    List<BuddyEntity> findAllByCustIdAndIsActv(Long custId, int isActv);
    
    List<BuddyEntity> findAllByIdAndIsActv(Long id, int isActv);

    BuddyEntity findBuddyEntitiesByIdAndIsActv(Long id, int isActv);

    boolean existsByCustIdAndIsActv(Long custId, int isActv);

    @Query(value = "SELECT b.id FROM BUDDY b WHERE IS_ACTV = 1 AND ST_ID = :stId AND PROVINCE_ID = :provinceID AND CUSTOMER_ID <> :custId  ORDER BY RANDOM() LIMIT 1" , nativeQuery = true)
    Long findRandomBuddy(@Param("stId") Long stId, @Param("provinceID") Long provinceID, @Param("custId") Long custId);

    List<BuddyEntity> findAllById(Long buddyId);

    @Query(value = "SELECT b.PROVINCE_ID from BUDDY b WHERE CUSTOMER_ID = :custId", nativeQuery = true)
    Long findProvinceIdByCustId(@Param("custId") Long custId);

    void deleteAllByCustId(Long custId);
}
