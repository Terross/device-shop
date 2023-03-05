package ru.leti.device.shop.model.device;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Headphones extends Device {

    private boolean wireless;
    private String constructionType;
    private boolean withMicrophone;
}
