package ru.leti.device.shop.model.order;

import jakarta.persistence.*;
import lombok.Data;
import ru.leti.device.shop.model.device.Device;
import ru.leti.device.shop.model.user.ShopUser;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class ShopOrder {

    @Id
    private UUID id;
    private int number;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "order_device",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "device_id")}
    )
    List<Device> devices;

    @ManyToOne(fetch = FetchType.LAZY)
    private ShopUser shopUser;
}
