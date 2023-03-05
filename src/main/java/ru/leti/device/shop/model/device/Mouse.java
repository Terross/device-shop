package ru.leti.device.shop.model.device;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Mouse extends Device {

    private boolean wireless;
    private int keyCount;
    private int dpi;
}
