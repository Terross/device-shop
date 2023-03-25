package ru.leti.device.shop.model.device;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class OrderDevice {

    @Id
    @GeneratedValue
    private UUID id;
    private UUID deviceId;
    private int count;
}
