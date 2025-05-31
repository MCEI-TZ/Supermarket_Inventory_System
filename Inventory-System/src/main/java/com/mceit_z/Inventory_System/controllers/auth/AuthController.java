package com.mceit_z.Inventory_System.controllers.auth;

import com.mceit_z.Inventory_System.config.jwt.JwtTokenProvider;
import com.mceit_z.Inventory_System.models.UserProfile;
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

    @Autowired
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserProfile userProfile) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userProfile.getUsername(),
                            userProfile.getPassword()
                    )
            );

            String token = jwtTokenProvider.generateToken(authentication);

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "username", authentication.getName()
            ));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid username or password"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "An error occurred during authentication"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserProfile user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encripta aquí
        userService.createUser(user);
        return ResponseEntity.ok("User Registered Successfully");
    }

}
