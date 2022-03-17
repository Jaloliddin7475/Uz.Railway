package uz.train.train.appbookingflights.Dto.createDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeatCreateDto {
    @NotNull
    private Integer seatNumber;
    @NotNull
    private double seatPrice;
    @NotNull
    private boolean seatStatus;

}
