package ru.leti.device.shop.model.device;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Keyboard extends Device {

    private boolean rgb;
    private boolean wireless;
    private String keyType;
}
