package uz.train.train.appbookingflights.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;
    @NotNull
    private String userRole;

}
