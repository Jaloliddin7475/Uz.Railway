package uz.train.train.appbookingflights.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.train.train.appbookingflights.Dto.UserDto;
import uz.train.train.appbookingflights.exception.ConflictException;
import uz.train.train.appbookingflights.exception.NotFoundException;
import uz.train.train.appbookingflights.mapper.UserMapper;
import uz.train.train.appbookingflights.model.UserEntity;
import uz.train.train.appbookingflights.reponse.ApiResponse;
import uz.train.train.appbookingflights.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ApiResponse getUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        List<UserEntity> users = userRepository.findAll();
        users.forEach(userEntity -> {
            UserDto userDto = userMapper.entityToResponseDTO(userEntity);
            userDtos.add(userDto);
        });
        return new ApiResponse(200,"users",userDtos);
    }

    public ApiResponse getUser(UUID id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found", UserEntity.class, "userId"));

        return new ApiResponse(200,"user",userMapper.entityToResponseDTO(userEntity));
    }

    public void addUser(UserDto userDto) {
        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());
        if (existsByPhoneNumber)
            throw new ConflictException("This phoneNumber already in use", UserEntity.class, "phoneNumber");

        UserEntity userEntity = userMapper.CreateDtoToEntity(userDto);
        userRepository.save(userEntity);
    }

    public ApiResponse editUser(UUID id, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found", UserEntity.class, "userId"));

        userMapper.updateEntity(userDto, userEntity);
        userRepository.save(userEntity);
        return new ApiResponse(200,"Successfully edited",userMapper.entityToResponseDTO(userEntity));
    }

    public ApiResponse deleteUser(UUID id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found", UserEntity.class, "userId"));

        userRepository.delete(userEntity);
        return new ApiResponse(200,"Successfully deleted");
    }
}
