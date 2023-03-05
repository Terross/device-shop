package ru.leti.device.shop.model.device;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Monitor extends Device {

    private String resolution;
    private int frequencyUpdate;
    private String matrixType;

}
