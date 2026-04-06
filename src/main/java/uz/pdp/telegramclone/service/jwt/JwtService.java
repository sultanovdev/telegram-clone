package uz.pdp.telegramclone.service.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private String expiration;

    public String generateToken(Authentication auth) {
        return Jwts.builder()
                .setSubject(auth.getName())
                .claim("roles", auth.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .filter(role -> role.startsWith("ROLE_"))
                        .collect(Collectors.toSet()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + Integer.parseInt(expiration)))
                .signWith(
                        Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8))
                )
                .compact();
    }
}
