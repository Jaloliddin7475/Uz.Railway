
package uz.train.train.appbookingflights.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.train.train.appbookingflights.Dto.createDto.TrainCreateDto;
import uz.train.train.appbookingflights.Dto.responseDto.TrainResponseDto;
import uz.train.train.appbookingflights.model.TrainEntity;

@Component
public class TrainMapper {
    private final ModelMapper mapper;

    public TrainMapper() {
        this.mapper = new ModelMapper();
    }

    public TrainResponseDto entityToResponseDTO(TrainEntity trainEntity) {
        return mapper.map(trainEntity, TrainResponseDto.class);
    }

    public TrainEntity createDtoToEntity(TrainCreateDto trainCreateDto){
        return mapper.map(trainCreateDto, TrainEntity.class);
    }

    public void updateEntity(TrainCreateDto trainCreateDto, Class<TrainEntity> trainEntityClass){
        mapper.map(trainCreateDto, trainEntityClass);
    }

}
