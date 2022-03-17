package uz.train.train.appbookingflights.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import uz.train.train.appbookingflights.Dto.createDto.PaymentCreateDto;
import uz.train.train.appbookingflights.Dto.responseDto.PaymentResponseDto;
import uz.train.train.appbookingflights.model.PaymentEntity;


@Component
public class PaymentMapper {
    private final ModelMapper mapper;

    public PaymentMapper() {
        this.mapper = new ModelMapper();
    }

    public PaymentResponseDto entityToResponseDto (PaymentEntity paymentEntity) {
        return mapper.map(paymentEntity,PaymentResponseDto.class);
    }

    public PaymentEntity createDtoToEntity(PaymentCreateDto paymentCreateDto) {
        return mapper.map(paymentCreateDto,PaymentEntity.class);
    }

    public void updateEntity(PaymentCreateDto paymentCreateDto, PaymentEntity paymentEntity) {
        mapper.map(paymentCreateDto,paymentEntity);
    }

}
