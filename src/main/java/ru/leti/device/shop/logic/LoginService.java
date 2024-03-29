package ru.leti.device.shop.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.leti.device.shop.model.user.ShopUser;
import ru.leti.device.shop.model.user.UserRole;
import ru.leti.device.shop.model.user.UserToken;
import ru.leti.device.shop.repository.UserRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public UserToken signIn(ShopUser shopUser) {
        ShopUser userFromDb = userRepository.findShopUserByEmail(shopUser.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found")); //TODO: сделать нормлаьную обработку ошибок
        if (!userFromDb.getPassword().equals(shopUser.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return new UserToken(userFromDb.getEmail(), userFromDb.getUserRole(), userFromDb.getId());
    }

    public UserToken signUp(ShopUser shopUser) {
        shopUser.setId(UUID.randomUUID());
        shopUser.setUserRole(UserRole.CUSTOMER);
        userRepository.save(shopUser);

        return new UserToken(shopUser.getEmail(), shopUser.getUserRole(), shopUser.getId());
    }
}
