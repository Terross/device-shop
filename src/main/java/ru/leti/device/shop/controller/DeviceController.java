package ru.leti.device.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.leti.device.shop.model.device.Device;
import ru.leti.device.shop.repository.DeviceRepository;

@RestController
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceRepository deviceRepository;

    @PostMapping("/device")
    public ResponseEntity<?> createDevice(@RequestBody Device device) {
        var result = deviceRepository.save(device);
        return ResponseEntity.ok(result);
    }

    //TODO:
    /*
        1. Авторизация пользователь и работник
        2. CRUD товара
        3. Оформление заказа
        4. Список заказов для работника
        5. Картинки
     */


}
