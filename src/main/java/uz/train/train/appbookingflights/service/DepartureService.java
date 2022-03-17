package uz.train.train.appbookingflights.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.train.train.appbookingflights.Dto.createDto.DepartureCreateDto;
import uz.train.train.appbookingflights.Dto.responseDto.DepartureResponseDto;
import uz.train.train.appbookingflights.exception.ConflictException;
import uz.train.train.appbookingflights.exception.NotFoundException;
import uz.train.train.appbookingflights.model.DepartureEntity;
import uz.train.train.appbookingflights.model.TrainEntity;
import uz.train.train.appbookingflights.reponse.ApiResponse;
import uz.train.train.appbookingflights.repository.DepartureRepository;
import uz.train.train.appbookingflights.repository.TrainRepository;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartureService {
    private final DepartureRepository departureRepository;
    private final TrainRepository trainRepository;

    public ApiResponse getDepartures() {
        List<DepartureEntity> departureEntities = departureRepository.findAll();
        List<DepartureResponseDto> departureResponseDtos = new ArrayList<>();
        for (DepartureEntity departureEntity : departureEntities) {
            DepartureResponseDto departureResponseDto = new DepartureResponseDto();
            departureResponseDto.setDepartureDate(departureEntity.getDate());
            departureResponseDto.setStartTime(departureEntity.getStartTime());
            departureResponseDto.setEndTime(departureEntity.getEndTime());
            departureResponseDto.setTrainNumber(departureEntity.getTrainEntity().getTrainNumber());
            departureResponseDtos.add(departureResponseDto);
        }
        return new ApiResponse(200,"Departures",departureResponseDtos);
    }

    public ApiResponse getDepartures (Integer id) {
        DepartureEntity departureEntity = departureRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Departure not found",DepartureEntity.class,"id"));

        DepartureResponseDto departureResponseDto = new DepartureResponseDto();
        departureResponseDto.setDepartureDate(departureEntity.getDate());
        departureResponseDto.setTrainNumber(departureEntity.getTrainEntity().getTrainNumber());
        departureResponseDto.setStartTime(departureEntity.getStartTime());
        departureResponseDto.setEndTime(departureEntity.getEndTime());
        return new ApiResponse(200,"Departurent",departureResponseDto);
    }

    public void addDepartures (DepartureCreateDto departureCreateDto) {
        TrainEntity trainEntity =  trainRepository.findById(departureCreateDto.getTrainId())
                .orElseThrow(() -> new NotFoundException("Train not found",TrainEntity.class,"trainId"));

        boolean exists = departureRepository.existsByDateAndTrainEntity(departureCreateDto.getDepartureDate(), trainEntity);
        if (exists) {
            throw new ConflictException("This departure is already exist",DepartureEntity.class,"date and train");
        }

        DepartureEntity departureEntity = new DepartureEntity();
        departureEntity.setTrainEntity(trainEntity);
        departureEntity.setDate(departureCreateDto.getDepartureDate());
        departureEntity.setStartTime(departureCreateDto.getStartTime());
        departureEntity.setEndTime(departureCreateDto.getEntTime());
        departureRepository.save(departureEntity);
    }

    public ApiResponse editDeparture (Integer id, DepartureCreateDto departureCreateDto) {
        DepartureEntity departureEntity =  departureRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Departure not found",DepartureEntity.class,"id"));

        TrainEntity trainEntity = trainRepository.findById(departureCreateDto.getTrainId())
                .orElseThrow(() -> new NotFoundException("Train not found",TrainEntity.class,"trainId"));

        DepartureEntity departureEntity1 = new DepartureEntity();
        departureEntity1.setTrainEntity(trainEntity);
        departureEntity1.setDate(departureCreateDto.getDepartureDate());
        departureEntity1.setStartTime(departureCreateDto.getStartTime());
        departureEntity1.setEndTime(departureCreateDto.getEntTime());
        DepartureEntity save = departureRepository.save(departureEntity1);
        return new ApiResponse(200,"Successfully updated",save);
    }

    public ApiResponse deleteDeparture (Integer id) {
        DepartureEntity departureEntity =  departureRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Departure not found",DepartureEntity.class,"id"));

        departureRepository.delete(departureEntity);
        return new ApiResponse(200,"Successfully deleted");
    }



}
