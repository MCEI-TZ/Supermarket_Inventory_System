package com.mceit_z.Inventory_System.controllers.auth;

import com.mceit_z.Inventory_System.config.jwt.JwtTokenProvider;
import com.mceit_z.Inventory_System.dto.user.LoginUserDTO;
import com.mceit_z.Inventory_System.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    // Inyección por constructor (recomendado)
    @Autowired
    public AuthController(
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            PasswordEncoder passwordEncoder,
            UserService userService
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDTO loginUserDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUserDTO.getUsername(),
                            loginUserDTO.getPassword()
                    )
            );

            String token = jwtTokenProvider.generateToken(authentication);

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "username", authentication.getName(),
                    "authorities", authentication.getAuthorities()
            ));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
        } catch (Exception e) {
            // ¡Registra el error real para diagnóstico!
            return ResponseEntity.status(500).body(Map.of(
                    "error", "Error en autenticación",
                    "message", e.getMessage()
            ));
        }
    }

}