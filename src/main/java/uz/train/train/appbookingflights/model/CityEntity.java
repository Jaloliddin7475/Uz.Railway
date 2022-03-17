package uz.train.train.appbookingflights.model;

import lombok.*;
import uz.train.train.appbookingflights.model.base.BaseEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class CityEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    private Integer cityNumber;

    @Column(nullable = false)
    private String cityName;
}
