package ru.leti.device.shop.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.leti.device.shop.model.device.Device;
import ru.leti.device.shop.model.device.OrderDevice;
import ru.leti.device.shop.model.order.ShopOrder;
import ru.leti.device.shop.repository.DeviceRepository;
import ru.leti.device.shop.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final DeviceRepository deviceRepository;

    public ShopOrder getOrderBy(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<ShopOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public ShopOrder createOrder(ShopOrder shopOrder) {
        shopOrder.getOrderDevices().stream()
                .forEach(orderDevice -> decreaseDeviceCount(orderDevice));
        shopOrder.setId(UUID.randomUUID());
        return orderRepository.save(shopOrder);
    }

    private void decreaseDeviceCount(OrderDevice orderDevice) {
        Device device = deviceRepository.findById(orderDevice.getDeviceId())
                .orElseThrow(() -> new RuntimeException("Device not found"));
        device.setCount(device.getCount() - orderDevice.getCount());
        deviceRepository.save(device);
    }

}
