package ru.leti.device.shop.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.leti.device.shop.model.device.Device;
import ru.leti.device.shop.repository.DeviceRepository;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public Device createDevice(Device device) {
        device.setId(UUID.randomUUID());
        return deviceRepository.save(device);
    }

    public Device updateDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device getDeviceBy(UUID id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public void deleteDeviceBy(UUID id) {
        deviceRepository.deleteById(id);
    }
}
