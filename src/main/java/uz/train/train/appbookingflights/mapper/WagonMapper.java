
package uz.train.train.appbookingflights.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.train.train.appbookingflights.Dto.createDto.WagonCreateDto;
import uz.train.train.appbookingflights.Dto.responseDto.WagonResponseDto;
import uz.train.train.appbookingflights.model.WagonEntity;

@Component
public class WagonMapper {
    private final ModelMapper mapper;

    public WagonMapper() {
        this.mapper = new ModelMapper();
    }

    public WagonResponseDto entityToResponseDTO(WagonEntity wagon) {
        return mapper.map(wagon, WagonResponseDto.class);
    }

    public WagonEntity createDtoToEntity(WagonCreateDto wagonCreateDto){
        return mapper.map(wagonCreateDto, WagonEntity.class);
    }

    public void updateEntity(WagonCreateDto wagonCreateDto, WagonEntity wagonEntity){
        mapper.map(wagonCreateDto, wagonEntity);
    }

}
