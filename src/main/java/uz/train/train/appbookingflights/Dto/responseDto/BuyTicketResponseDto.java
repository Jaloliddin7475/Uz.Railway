package uz.train.train.appbookingflights.Dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyTicketResponseDto {

    private String fromPlace;
    private String toPlace;
    private LocalDate when;
    private String passengerName;
    private String departure;
}
