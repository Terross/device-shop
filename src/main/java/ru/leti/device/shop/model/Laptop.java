package ru.leti.device.shop.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Laptop extends Device {

    private String operationSystem;
}
