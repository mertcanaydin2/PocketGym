package greedzCorp.pocketGym.dataAccess;

import greedzCorp.pocketGym.entities.PartyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<PartyEntity, Integer> {

    boolean existsByMobilePhoneAndPartyState(String mobilePhone, Long State);
}
