package ru.leti.device.shop.configuration.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import ru.leti.device.shop.repository.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SecurityInterceptor implements HandlerInterceptor {
    private final static String USER_TOKEN = "USER-TOKEN";
    private final static List<String> ALLOWED_PATH = List.of("/login/sign/up", "/login/sign/in", "/swagger-ui/index.html",
            "/swagger-ui/swagger-initializer.js", "/v3/api-docs/swagger-config", "/swagger-ui/swagger-ui.css", "/swagger-ui/swagger-ui-bundle.js",
            "/swagger-ui/index.css", "/swagger-ui/swagger-ui-standalone-preset.js", "/v3/api-docs");

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userToken = request.getHeader(USER_TOKEN);
        String path = request.getRequestURI();
        if (!ALLOWED_PATH.contains(path) && userToken == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw new RuntimeException("Unauthorized");
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
