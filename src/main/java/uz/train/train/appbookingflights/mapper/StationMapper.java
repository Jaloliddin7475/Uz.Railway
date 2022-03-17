
package uz.train.train.appbookingflights.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.train.train.appbookingflights.Dto.createDto.StationsCreateDto;
import uz.train.train.appbookingflights.Dto.responseDto.StationsResponseDto;
import uz.train.train.appbookingflights.model.StationEntity;

@Component
public class StationMapper {
    private final ModelMapper mapper;

    public StationMapper() {
        this.mapper = new ModelMapper();
    }

    public StationsResponseDto entityToResponseDTO(StationEntity stationEntity) {
        return mapper.map(stationEntity, StationsResponseDto.class);
    }

    public StationEntity createDtoToEntity(StationsCreateDto stationsCreateDto){
        return mapper.map(stationsCreateDto, StationEntity.class);
    }

    public void updateEntity(StationsCreateDto stationsCreateDto, Class<StationEntity> station){
        mapper.map(stationsCreateDto, station);
    }

}
