package uz.train.train.appbookingflights.Dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartureResponseDto {

    private String trainNumber;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate departureDate;
}
