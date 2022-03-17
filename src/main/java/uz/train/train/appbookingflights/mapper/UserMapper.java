
package uz.train.train.appbookingflights.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.train.train.appbookingflights.Dto.UserDto;
import uz.train.train.appbookingflights.model.UserEntity;

@Component
public class UserMapper {
    private final ModelMapper mapper;

    public UserMapper() {
        this.mapper = new ModelMapper();
    }

    public UserDto entityToResponseDTO(UserEntity user) {
        return mapper.map(user, UserDto.class);
    }

    public UserEntity CreateDtoToEntity(UserDto userDto){
        return mapper.map(userDto, UserEntity.class);
    }

    public void updateEntity(UserDto userDto,UserEntity userEntity){
        mapper.map(userDto, userEntity);
    }

}
