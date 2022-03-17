package uz.train.train.appbookingflights.Dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PassengerResponseDto {
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String gender;
    private LocalDate birthday;
    private String passport;
}
