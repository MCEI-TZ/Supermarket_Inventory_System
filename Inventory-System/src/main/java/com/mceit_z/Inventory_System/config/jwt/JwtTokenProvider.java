package com.mceit_z.Inventory_System.config.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expiration-ms}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) throws JOSEException {
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .subject(authentication.getName())
                .issueTime(new Date())
                .expirationTime(new Date(System.currentTimeMillis()+jwtExpirationInMs))
                .build();
        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader.Builder(JWSAlgorithm.HS256).build(),
                claims
        );
        signedJWT.sign(new MACSigner(jwtSecret.getBytes()));
        return signedJWT.serialize();
    }
    public String getUsernameFromToken(String token){
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claims = signedJWT.getJWTClaimsSet();
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validateToken(String token){
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);

            boolean validSignature = signedJWT.verify(new MACVerifier(jwtSecret.getBytes()));

            boolean notExpired = new Date().before(signedJWT.getJWTClaimsSet().getExpirationTime());

            return  validSignature && notExpired;
        } catch (Exception e) {
            return false;
        }
    }
}
