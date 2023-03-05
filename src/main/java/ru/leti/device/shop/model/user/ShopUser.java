package ru.leti.device.shop.model.user;

import jakarta.persistence.*;
import lombok.Data;
import ru.leti.device.shop.model.order.ShopOrder;

import java.util.UUID;

@Data
@Entity
public class ShopUser {

    @Id
    private UUID id;

    private String firstName;
    private String secondName;

    @OneToOne(mappedBy = "user")
    private ShopOrder order;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
