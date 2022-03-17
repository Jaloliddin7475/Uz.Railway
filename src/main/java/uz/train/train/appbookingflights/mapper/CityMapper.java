package uz.train.train.appbookingflights.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.train.train.appbookingflights.Dto.CityDto;
import uz.train.train.appbookingflights.model.CityEntity;


@Component
public class CityMapper {
    private final ModelMapper mapper;

    public CityMapper() {
        this.mapper = new ModelMapper();
    }

    public CityDto entityToResponseDTO(CityEntity city) {
        return mapper.map(city, CityDto.class);
    }

    public CityEntity CreateDtoToEntity(CityDto cityDto){
        return mapper.map(cityDto, CityEntity.class);
    }

    public void updateEntity(CityDto cityDto,CityEntity cityEntity){
        mapper.map(cityDto, cityEntity);
    }
}
