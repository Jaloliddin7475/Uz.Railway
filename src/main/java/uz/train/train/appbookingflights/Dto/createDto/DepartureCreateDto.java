package uz.train.train.appbookingflights.Dto.createDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartureCreateDto {
    @NotNull
    private String name;
    @NotNull
    private Integer trainId;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime entTime;
    @NotNull
    private LocalDate departureDate;

}
