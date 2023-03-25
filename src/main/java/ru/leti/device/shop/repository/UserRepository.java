package ru.leti.device.shop.repository;

import org.springframework.data.repository.CrudRepository;
import ru.leti.device.shop.model.user.ShopUser;

import java.util.UUID;

public interface UserRepository extends CrudRepository<ShopUser, UUID> {
}
