package ru.leti.device.shop.model.user;

import java.util.UUID;

public record UserToken(String email, UserRole userRole, UUID id) {
}
