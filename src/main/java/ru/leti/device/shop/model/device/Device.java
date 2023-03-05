package ru.leti.device.shop.model.device;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;
import ru.leti.device.shop.model.order.ShopOrder;

import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.InheritanceType.JOINED;

@Data
@Entity
@Inheritance(strategy = JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Laptop.class, name = "laptop"),
        @JsonSubTypes.Type(value = Mouse.class, name = "mouse"),
        @JsonSubTypes.Type(value = Headphones.class, name = "headphones"),
        @JsonSubTypes.Type(value = Phone.class, name = "phone"),
        @JsonSubTypes.Type(value = Monitor.class, name = "monitor")
})
public abstract class Device {

    @Id
    private UUID id;
    private int count;
    private double price;
    private String name;
    private String producer;
    private double rating;
    @Enumerated(EnumType.STRING)
    private DeviceType type;

    @ManyToMany(mappedBy = "devices")
    private Set<ShopOrder> orders;
}
