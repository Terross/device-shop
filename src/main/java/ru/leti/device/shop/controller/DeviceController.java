package ru.leti.device.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.leti.device.shop.logic.DeviceService;
import ru.leti.device.shop.model.device.Device;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "device", description = "Device API")
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping("/device")
    @Operation(summary = "Create device")
    public ResponseEntity<?> createDevice(@RequestBody Device device) {
        return ResponseEntity.ok(deviceService.createDevice(device));
    }

    @GetMapping("/device/{id}")
    @Operation(summary = "Get device by id")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(deviceService.getDeviceBy(id));
    }

    @GetMapping("/device")
    @Operation(summary = "Get all devices")
    public ResponseEntity<List<Device>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @DeleteMapping("/device/{id}")
    @Operation(summary = "Delete device by id")
    public ResponseEntity<?> deleteDevice(@PathVariable("id") UUID id) {
        deviceService.deleteDeviceBy(id);
        return ResponseEntity.ok("Ok");
    }

    @PutMapping("/device")
    @Operation(summary = "Update device")
    public ResponseEntity<?> updateDevice(@RequestBody Device device) {
        return ResponseEntity.ok(deviceService.updateDevice(device));
    }


    //TODO:
    /*
        3. Оформление заказа
        4. Список заказов для работника
        5. Картинки
     */


}
