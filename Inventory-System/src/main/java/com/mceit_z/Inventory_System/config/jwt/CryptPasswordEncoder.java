package com.mceit_z.Inventory_System.config.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptPasswordEncoder {
    BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();

    public String encode(String password) {
        return encrypt.encode(password);
    }
}
