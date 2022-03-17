package uz.train.train.appbookingflights.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.train.train.appbookingflights.Dto.createDto.PaymentCreateDto;
import uz.train.train.appbookingflights.Dto.responseDto.PaymentResponseDto;
import uz.train.train.appbookingflights.exception.ConflictException;
import uz.train.train.appbookingflights.exception.NotFoundException;
import uz.train.train.appbookingflights.mapper.PaymentMapper;
import uz.train.train.appbookingflights.model.PaymentEntity;
import uz.train.train.appbookingflights.reponse.ApiResponse;
import uz.train.train.appbookingflights.repository.PaymentRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;

    public ApiResponse getPayments() {
        List<PaymentResponseDto> dtoList = new ArrayList<>();
        List<PaymentEntity> paymentRepositoryAll = paymentRepository.findAll();
        for (PaymentEntity paymentEntity : paymentRepositoryAll) {
            dtoList.add(paymentMapper.entityToResponseDto(paymentEntity));
        }
        return new ApiResponse(200,"payments",dtoList);
    }

    public ApiResponse getPayment(Integer id) {
        PaymentEntity paymentEntity =  paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found",PaymentEntity.class,"id"));
        return new ApiResponse(200,"payment",paymentMapper.entityToResponseDto(paymentEntity));
    }

    public void addPayment(PaymentCreateDto paymentCreateDto) {
        boolean exists = paymentRepository.existsByName(paymentCreateDto.getName());
        if (exists) {
            throw new ConflictException("This payment already exist",PaymentEntity.class,"name");
        }
        PaymentEntity paymentEntity = paymentMapper.createDtoToEntity(paymentCreateDto);
        PaymentEntity save = paymentRepository.save(paymentEntity);
    }

    public ApiResponse editPayment (Integer id,PaymentCreateDto paymentCreateDto) {
        PaymentEntity paymentEntity =  paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found",PaymentEntity.class,"id"));

        paymentMapper.updateEntity(paymentCreateDto,paymentEntity);
        return new ApiResponse(200,"Successfully edited",paymentMapper.entityToResponseDto(paymentEntity));
    }

    public ApiResponse deletePayment (Integer id) {
        PaymentEntity paymentEntity =  paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found",PaymentEntity.class,"id"));

        paymentRepository.delete(paymentEntity);
        return new ApiResponse(200,"Successfully deleted");
    }

}
