package ru.leti.device.shop.model.order;

import jakarta.persistence.*;
import lombok.Data;
import ru.leti.device.shop.model.device.OrderDevice;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class ShopOrder {

    @Id
    private UUID id;
    private int number;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    List<OrderDevice> orderDevices;

    private UUID userId;
}
