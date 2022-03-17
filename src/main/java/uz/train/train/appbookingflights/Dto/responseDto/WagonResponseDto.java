package uz.train.train.appbookingflights.Dto.responseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WagonResponseDto {
    private Integer wagonNumber;
    private Integer maxSeats;
    private Integer countOfSeats;
    private boolean wagonStatus;
    private String trainName;
    private String trainNumber;

}
