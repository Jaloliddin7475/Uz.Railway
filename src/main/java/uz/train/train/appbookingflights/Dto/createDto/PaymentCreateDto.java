package uz.train.train.appbookingflights.Dto.createDto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentCreateDto {
    @NotNull
    private String name;
    @NotNull
    private String cardNumber;
    @NotNull
    private String expiryDate;

}
