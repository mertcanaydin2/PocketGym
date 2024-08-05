package greedzCorp.pocketGym.dataAccess;

import greedzCorp.pocketGym.entities.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerDao extends JpaRepository<TrainerEntity, Integer> {

    List<TrainerEntity> getAllById(Long trainerId);
    List<TrainerEntity> findAllByFirstNameAndLastNameAndIsActv(String firstName, String lastName, int isActv);
    List<TrainerEntity> findAllByFirstNameAndIsActv(String firstName, int isActv);
    List<TrainerEntity> findAllByLastNameAndIsActv(String lastName, int isActv);
}
