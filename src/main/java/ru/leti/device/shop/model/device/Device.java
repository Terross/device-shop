package ru.leti.device.shop.model.device;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import lombok.Data;

import java.util.UUID;

import static jakarta.persistence.InheritanceType.JOINED;

@Data
@Entity
@Inheritance(strategy = JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Laptop.class, name = "LAPTOP"),
        @JsonSubTypes.Type(value = Mouse.class, name = "MOUSE"),
        @JsonSubTypes.Type(value = Headphones.class, name = "HEADPHONES"),
        @JsonSubTypes.Type(value = Phone.class, name = "PHONE"),
        @JsonSubTypes.Type(value = Monitor.class, name = "MONITOR")
})
public abstract class Device {

    @Id
    private UUID id;
    private int count;
    private double price;
    private String name;
    private String producer;
    private double rating;
}
