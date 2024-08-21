package com.producerMessage.rabbitmq.security;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.producerMessage.rabbitmq.security.authUser.UserDetailDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TokenService {

    @Value("${spring.jwt.secret}")
    private String secret;

    private static final int MINUTES = 60 * 24;

    public String generateToken(String email) {
        var now = Instant.now();
        return Jwts.builder()
                .setSubject(email)
                .setIssuer("API Producer")
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(MINUTES, ChronoUnit.MINUTES)))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return getTokenBody(token).getSubject();
    }

    public Boolean validateToken(String token, String login) {
        final String username = extractUsername(token);
        return username.equals(login) && !isTokenExpired(token);
    }

    private Claims getTokenBody(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(getSignInKey())
                    .build()
                    .parseClaimsJws(token);

            return claimsJws.getBody();
        } catch (SignatureException | ExpiredJwtException e) { // Invalid signature or expired token
            throw new AccessDeniedException("Access denied: " + e.getMessage());
        }
    }

    private boolean isTokenExpired(String token) {
        Claims claims = getTokenBody(token);
        return claims.getExpiration().before(new Date());
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public UserDetailDTO getDto(String jwtToken) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSignInKey())
                    .requireIssuer("API Producer")
                    .build()
                    .parseClaimsJws(jwtToken)
                    .getBody();

            return UserDetailDTO.builder()
                    .name(claims.getSubject())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Token Inválido", e);
        }
    }
}