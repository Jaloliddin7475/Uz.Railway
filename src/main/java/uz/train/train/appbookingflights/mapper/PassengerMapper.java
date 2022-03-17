package uz.train.train.appbookingflights.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.train.train.appbookingflights.Dto.createDto.PassengerCreateDto;
import uz.train.train.appbookingflights.Dto.responseDto.PassengerResponseDto;
import uz.train.train.appbookingflights.model.PassengerEntity;

@Component
public class PassengerMapper {

    private final ModelMapper mapper;

    public PassengerMapper() {
        this.mapper = new ModelMapper();
    }
    public PassengerResponseDto entityToResponseDTO(PassengerEntity passengerEntity) {
        return mapper.map(passengerEntity, PassengerResponseDto.class);
    }

    public PassengerEntity CreateDtoToEntity(PassengerCreateDto passengerCreateDto){
        return mapper.map(passengerCreateDto, PassengerEntity.class);
    }

    public void updateEntity(PassengerCreateDto passengerCreateDto, PassengerEntity passengerEntity){
        mapper.map(passengerCreateDto, passengerEntity);
    }

}
