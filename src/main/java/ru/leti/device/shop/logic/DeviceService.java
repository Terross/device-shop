package ru.leti.device.shop.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.leti.device.shop.model.device.Device;
import ru.leti.device.shop.repository.DeviceRepository;

@Component
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }
}
