package ru.leti.device.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import lombok.Data;

import java.util.UUID;

import static jakarta.persistence.InheritanceType.JOINED;

@Data
@Entity
@Inheritance(strategy = JOINED)
public abstract class Device {

    @Id
    private UUID id;
    private int count;
    private double price;
    private String name;
    private DeviceType type;
}
