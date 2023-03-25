package ru.leti.device.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.leti.device.shop.logic.LoginService;
import ru.leti.device.shop.model.user.ShopUser;
import ru.leti.device.shop.model.user.UserToken;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final LoginService loginService;

    @PostMapping("/login/sign/in")
    public ResponseEntity<UserToken> signIn(@RequestBody ShopUser shopUser) {
        return ResponseEntity.ok(loginService.signIn(shopUser));
    }

    @PostMapping("/login/sign/up")
    public ResponseEntity<UserToken> signUp(@RequestBody ShopUser shopUser) {
        return ResponseEntity.ok(loginService.signUp(shopUser));
    }
}
