package uz.train.train.appbookingflights.Dto.createDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuyTicketCreateDto {
    @NotNull
    private Integer fromPlaceId;
    @NotNull
    private Integer toPlaceId;
    @NotNull
    private Integer departureId;
    @NotNull
    private Integer paymentId;
    @NotNull
    private UUID passengerId;
}
