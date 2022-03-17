package uz.train.train.appbookingflights.Dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StationsResponseDto {
    private Integer cityNumber;
    private String cityName;
    private String stationName;
    private String details;
}
