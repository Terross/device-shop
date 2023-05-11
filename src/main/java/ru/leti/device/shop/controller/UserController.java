package ru.leti.device.shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.leti.device.shop.logic.LoginService;
import ru.leti.device.shop.model.user.ShopUser;
import ru.leti.device.shop.model.user.UserToken;
import ru.leti.device.shop.repository.UserRepository;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "user", description = "User API")
public class UserController {

    private final LoginService loginService;
    private final UserRepository userRepository;

    @PostMapping("/login/sign/in")
    @Operation(summary = "Sign in")
    public ResponseEntity<UserToken> signIn(@RequestBody ShopUser shopUser) {
        return ResponseEntity.ok(loginService.signIn(shopUser));
    }

    @PostMapping("/login/sign/up")
    @Operation(summary = "Sign up")
    public ResponseEntity<UserToken> signUp(@RequestBody ShopUser shopUser) {
        return ResponseEntity.ok(loginService.signUp(shopUser));
    }

    @GetMapping("/user")
    @Operation(summary = "Get user email")
    public ResponseEntity<Iterable<ShopUser>> getUserEmail() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
