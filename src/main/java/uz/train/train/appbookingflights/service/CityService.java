package uz.train.train.appbookingflights.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.train.train.appbookingflights.Dto.CityDto;
import uz.train.train.appbookingflights.exception.ConflictException;
import uz.train.train.appbookingflights.exception.NotFoundException;
import uz.train.train.appbookingflights.mapper.CityMapper;
import uz.train.train.appbookingflights.model.CityEntity;
import uz.train.train.appbookingflights.model.TrainEntity;
import uz.train.train.appbookingflights.reponse.ApiResponse;
import uz.train.train.appbookingflights.repository.CityRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public ApiResponse getCities () {
        List<CityDto> cityDtos = new ArrayList<>();
        List<CityEntity> cityEntities = cityRepository.findAll();
        for (CityEntity city: cityEntities) {
            cityDtos.add(cityMapper.entityToResponseDTO(city));
        }
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(cityDtos);
        apiResponse.setMessage("cities");
        apiResponse.setStatusCode(200);
        return apiResponse;
    }

    public ApiResponse getCity (Integer id) {
        CityEntity cityEntity =  cityRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("City not found",CityEntity.class,"id"));

        return new ApiResponse(200,"city",cityMapper.entityToResponseDTO(cityEntity));
    }

    public void addCity(CityDto cityDto) {
        boolean existsByCityNumber = cityRepository.existsByCityNumber(cityDto.getCityNumber());
        if (existsByCityNumber) {
            throw new ConflictException("This CityNumber is already exist",CityEntity.class,"cityNumber");
        }

        CityEntity cityEntity = cityMapper.CreateDtoToEntity(cityDto);
        CityEntity saveCityEntity = cityRepository.save(cityEntity);
    }

    public ApiResponse editCity (Integer id, CityDto cityDto) {
        CityEntity cityEntity =  cityRepository.findById(id)
                .orElseThrow(() -> new ConflictException("City not found",CityEntity.class,"id"));
        cityMapper.updateEntity(cityDto,cityEntity);
        cityRepository.save(cityEntity);

        return new ApiResponse(200,"Successfully edited",cityMapper.entityToResponseDTO(cityEntity));
    }

    public ApiResponse deleteCity(String cityNumber) {
        Integer cityNumber1 = Integer.parseInt(cityNumber);
        CityEntity cityEntity = cityRepository.findByCityNumber(cityNumber1)
                .orElseThrow(() -> new NotFoundException("unable to find train by given trainNumber", TrainEntity.class, "trainNumber"));

        cityRepository.delete(cityEntity);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(200);
        apiResponse.setMessage("successfully deletes");
        return apiResponse;
    }

}
