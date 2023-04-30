package ru.leti.device.shop.model.user;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class ShopUser {

    @Id
    private UUID id;

    private String firstName;
    private String secondName;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
