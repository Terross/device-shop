package ru.leti.device.shop.repository;

import org.springframework.data.repository.CrudRepository;
import ru.leti.device.shop.model.order.ShopOrder;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<ShopOrder, UUID> {

    List<ShopOrder> findAll();
}
