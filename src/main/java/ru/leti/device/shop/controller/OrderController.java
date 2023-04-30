package ru.leti.device.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.leti.device.shop.logic.OrderService;
import ru.leti.device.shop.model.order.ShopOrder;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@Tag(name = "order", description = "Order API")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order")
    @Operation(summary = "Get all orders")
    public ResponseEntity<List<ShopOrder>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/order/{id}")
    @Operation(summary = "Get order by id")
    public ResponseEntity<ShopOrder> getOrderById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(orderService.getOrderBy(id));
    }

    @PostMapping("/order")
    @Operation(summary = "Create order")
    public ResponseEntity<?> createOrder(@RequestBody ShopOrder shopOrder) {
        return ResponseEntity.ok(orderService.createOrder(shopOrder));
    }
}
