package uz.train.train.appbookingflights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.train.train.appbookingflights.model.CityEntity;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<CityEntity,Integer> {
    boolean existsByCityNumber(Integer cityNumber);
    Optional<CityEntity> findByCityNumber(Integer cityNumber);
}
