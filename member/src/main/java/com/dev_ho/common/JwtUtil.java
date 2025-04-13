package com.dev_ho.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    // 토큰 유효시간
    private static final long JWT_TOKEN_EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    // 시크릿 키 > config로 빼자
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    // jwt 생성
    public String generateToken(String userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_TOKEN_EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(userId)
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.ES512)
                .compact();
    }
}
