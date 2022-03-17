package uz.train.train.appbookingflights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.train.train.appbookingflights.model.DepartureEntity;
import uz.train.train.appbookingflights.model.TrainEntity;

import java.time.LocalDate;

@Repository
public interface DepartureRepository extends JpaRepository<DepartureEntity,Integer> {
    boolean existsByDateAndTrainEntity(LocalDate date, TrainEntity trainEntity);
}
