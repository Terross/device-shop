package ru.leti.device.shop.model.device;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Phone extends Device {
    private String operationSystem;
    private String screenDiagonal;
    private int ram;
    private int rom;
}
