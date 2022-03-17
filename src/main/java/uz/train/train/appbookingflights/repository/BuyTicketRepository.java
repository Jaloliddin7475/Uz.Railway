package uz.train.train.appbookingflights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.train.train.appbookingflights.model.BuyTicketEntity;
import uz.train.train.appbookingflights.model.PassengerEntity;

import java.time.LocalDate;

@Repository
public interface BuyTicketRepository extends JpaRepository<BuyTicketEntity,Integer> {
    boolean existsByPassengerAndDepartureDate(PassengerEntity passenger, LocalDate departureDate);
}
