package ru.leti.device.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.leti.device.shop.model.device.OrderDevice;

import java.util.UUID;

@Repository
public interface OrderDeviceRepository extends CrudRepository<OrderDevice, UUID> {
}
