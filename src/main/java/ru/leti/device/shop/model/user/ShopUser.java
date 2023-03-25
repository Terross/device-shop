package ru.leti.device.shop.model.user;

import jakarta.persistence.*;
import lombok.Data;
import ru.leti.device.shop.model.order.ShopOrder;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class ShopUser {

    @Id
    private UUID id;

    private String firstName;
    private String secondName;
    private String password;

    @OneToMany(mappedBy = "shopUser", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ShopOrder> orders;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
