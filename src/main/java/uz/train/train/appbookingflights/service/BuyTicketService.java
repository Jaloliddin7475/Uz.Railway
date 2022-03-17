package uz.train.train.appbookingflights.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.train.train.appbookingflights.Dto.createDto.BuyTicketCreateDto;
import uz.train.train.appbookingflights.Dto.responseDto.BuyTicketResponseDto;
import uz.train.train.appbookingflights.exception.ConflictException;
import uz.train.train.appbookingflights.exception.NotFoundException;
import uz.train.train.appbookingflights.model.*;
import uz.train.train.appbookingflights.reponse.ApiResponse;
import uz.train.train.appbookingflights.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyTicketService {
    private final BuyTicketRepository buyTicketRepository;
    private final CityRepository cityRepository;
    private final PassengerRepository passengerRepository;
    private final DepartureRepository departureRepository;
    private final PaymentRepository paymentRepository;


    public ApiResponse getTickets () {
        List<BuyTicketResponseDto> buyTicketResponseDtos = new ArrayList<>();
        List<BuyTicketEntity> buyTicketRepositoryAll = buyTicketRepository.findAll();
        for (BuyTicketEntity buyTicketEntity : buyTicketRepositoryAll) {
            BuyTicketResponseDto ticketResponseDto = new BuyTicketResponseDto();
            ticketResponseDto.setFromPlace(buyTicketEntity.getFromCity().getCityName());
            ticketResponseDto.setToPlace(buyTicketEntity.getToCity().getCityName());
            ticketResponseDto.setWhen(buyTicketEntity.getDepartureDate());
            ticketResponseDto.setPassengerName(buyTicketEntity.getPassenger().getFirstName());
            ticketResponseDto.setDeparture(buyTicketEntity.getDepartureEntity().getTrainEntity().getTrainNumber() + " " +  buyTicketEntity.getDepartureEntity().getTrainEntity().getName());
            buyTicketResponseDtos.add(ticketResponseDto);
        }
        return new ApiResponse(200,"Tickets",buyTicketResponseDtos);
    }

    public ApiResponse getTicket (Integer id) {
        BuyTicketEntity buyTicketEntity = buyTicketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket not found",BuyTicketEntity.class,"id"));

        BuyTicketResponseDto buyTicketResponseDto = new BuyTicketResponseDto();
        buyTicketResponseDto.setFromPlace(buyTicketEntity.getFromCity().getCityName());
        buyTicketResponseDto.setToPlace(buyTicketEntity.getToCity().getCityName());
        buyTicketResponseDto.setWhen(buyTicketEntity.getDepartureDate());
        buyTicketResponseDto.setPassengerName(buyTicketEntity.getPassenger().getFirstName());
        buyTicketResponseDto.setDeparture(buyTicketEntity.getDepartureEntity().getTrainEntity().getTrainNumber() + " " +  buyTicketEntity.getDepartureEntity().getTrainEntity().getName());
        return new ApiResponse(200,"Ticket",buyTicketResponseDto);
    }

    public void addTicket (BuyTicketCreateDto buyTicketCreateDto) {
        PassengerEntity passengerEntity = passengerRepository.findById(buyTicketCreateDto.getPassengerId())
                .orElseThrow(() -> new NotFoundException("Passenger not found",PassengerEntity.class,"passengerId"));

        CityEntity fromCity = cityRepository.findById(buyTicketCreateDto.getFromPlaceId())
                .orElseThrow(() -> new NotFoundException("FromCity not found",CityEntity.class,"cityId"));

        CityEntity toCity = cityRepository.findById(buyTicketCreateDto.getToPlaceId())
                .orElseThrow(() -> new NotFoundException("ToCity not found",CityEntity.class,"cityId"));

        DepartureEntity departureEntity = departureRepository.findById(buyTicketCreateDto.getDepartureId())
                .orElseThrow(() -> new NotFoundException("Departure not found",DepartureEntity.class,"departureId"));

        PaymentEntity paymentEntity = paymentRepository.findById(buyTicketCreateDto.getPaymentId())
                .orElseThrow(() -> new NotFoundException("Payment not found",PaymentEntity.class,"paymentId"));

        BuyTicketEntity buyTicketEntity = new BuyTicketEntity();
        boolean exists = buyTicketRepository.existsByPassengerAndDepartureDate(passengerEntity, departureEntity.getDate());
        if (exists) {
            throw new ConflictException("Ticket already exist",BuyTicketEntity.class,"id");
        }
        buyTicketEntity.setDepartureEntity(departureEntity);
        buyTicketEntity.setFromCity(fromCity);
        buyTicketEntity.setToCity(toCity);
        buyTicketEntity.setPassenger(passengerEntity);
        List<PaymentEntity> paymentList = buyTicketEntity.getPaymentList();
        paymentList.add(paymentEntity);
        buyTicketEntity.setPaymentList(paymentList);
        BuyTicketEntity save = buyTicketRepository.save(buyTicketEntity);
    }

    public ApiResponse editTicket(Integer id, BuyTicketCreateDto buyTicketCreateDto) {
        BuyTicketEntity buyTicketEntity1 = buyTicketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket not found",BuyTicketEntity.class,"id"));

        PassengerEntity passengerEntity1 = passengerRepository.findById(buyTicketCreateDto.getPassengerId())
                .orElseThrow(() -> new NotFoundException("Passenger not found",PassengerEntity.class,"passengerId"));

        CityEntity fromCity = cityRepository.findById(buyTicketCreateDto.getFromPlaceId())
                .orElseThrow(() -> new NotFoundException("FromCity not found",CityEntity.class,"cityId"));

        CityEntity toCity = cityRepository.findById(buyTicketCreateDto.getToPlaceId())
                .orElseThrow(() -> new NotFoundException("ToCity not found",CityEntity.class,"cityId"));

        DepartureEntity departureEntity = departureRepository.findById(buyTicketCreateDto.getDepartureId())
                .orElseThrow(() -> new NotFoundException("Departure not found",DepartureEntity.class,"departureId"));

        PaymentEntity paymentEntity1 = paymentRepository.findById(buyTicketCreateDto.getPaymentId())
                .orElseThrow(() -> new NotFoundException("Payment not found",PaymentEntity.class,"paymentId"));

        buyTicketEntity1.setDepartureEntity(departureEntity);
        buyTicketEntity1.setFromCity(fromCity);
        buyTicketEntity1.setToCity(toCity);
        buyTicketEntity1.setPassenger(passengerEntity1);
        List<PaymentEntity> paymentList = buyTicketEntity1.getPaymentList();
        paymentList.add(paymentEntity1);
        buyTicketEntity1.setPaymentList(paymentList);
        BuyTicketEntity save = buyTicketRepository.save(buyTicketEntity1);
        return new ApiResponse(200,"Successfully updated",save.getId());
    }

    public ApiResponse deleteTicket (Integer id) {
        BuyTicketEntity buyTicketEntity = buyTicketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ticket not found",BuyTicketEntity.class,"id"));

        buyTicketRepository.delete(buyTicketEntity);
        return new ApiResponse(200,"Successfully deleted");
    }
}
