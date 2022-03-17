
package uz.train.train.appbookingflights.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.train.train.appbookingflights.Dto.createDto.SeatCreateDto;
import uz.train.train.appbookingflights.Dto.responseDto.SeatResponseDto;
import uz.train.train.appbookingflights.model.SeatEntity;

@Component
public class SeatMapper {
    private final ModelMapper mapper;

    public SeatMapper() {
        this.mapper = new ModelMapper();
    }

    public SeatResponseDto entityToResponseDTO(SeatEntity seat) {
        return mapper.map(seat, SeatResponseDto.class);
    }

    public SeatEntity CreateDtoToEntity(SeatCreateDto seatCreateDto){
        return mapper.map(seatCreateDto, SeatEntity.class);
    }

    public void updateEntity(SeatCreateDto seatCreateDto, SeatEntity seat){
        mapper.map(seatCreateDto, seat);
    }

}
