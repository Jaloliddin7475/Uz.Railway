package uz.train.train.appbookingflights.Dto.responseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentResponseDto {
    private String name;
    private String cardNumber;
    private String expiryDate;
    private LocalDate issuedDate;
}
