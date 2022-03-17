package uz.train.train.appbookingflights.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityDto {
    @NotNull
    private Integer cityNumber;
    @NotNull
    private String cityName;

}
