package uz.train.train.appbookingflights.Dto.createDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrainCreateDto {
    @NotNull
    private String name;
    @NotNull
    private Integer fromStationId;
    @NotNull
    private Integer toStationId;
    @NotNull
    private String trainNumber;
    @NotNull
    private String maxWagons;
    @NotNull
    private String countOfWagons;
    @NotNull
    private boolean trainStatus;
    @NotNull
    private List<Integer> includeStations;

}
