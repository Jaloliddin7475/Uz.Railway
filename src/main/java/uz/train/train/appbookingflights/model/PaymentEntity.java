package uz.train.train.appbookingflights.model;

import lombok.*;
import uz.train.train.appbookingflights.model.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class PaymentEntity extends BaseEntity {

    private String name;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String expiryDate;

    @ManyToMany
    private List<BuyTicketEntity> buyTicketList;

}
