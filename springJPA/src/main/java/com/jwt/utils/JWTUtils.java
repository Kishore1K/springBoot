package com.jwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JWTUtils {
    public static final long JWT_TOKEN_VALIDITY=5*60*60;
    public static final String ROLES = "ROLES";


    @Value("${jwt.secret}")
    private String secret;

    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final  Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }


  //retrieve username from jwt token
    public String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public List<String> getRoles(String token) {
        return getClaimFromToken(token, claims -> (List) claims.get(ROLES));
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(Authentication authentication){
        final Map<String, Object> claims = new HashMap<>();
        final UserDetails user = (UserDetails) authentication.getPrincipal();

        final List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        claims.put(ROLES, roles);
        return generateToken(claims, user.getUsername());
    }

    private String generateToken(Map<String, Object> claims, String subject){
        final long now = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now+JWT_TOKEN_VALIDITY*1000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS512).compact();
    }
    private Key getSigningKey() {
        byte[] keyBytes = this.secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Boolean validateToken(String token) {
        final String username = getUsernameFromToken(token);
        return username != null && !isTokenExpired(token);
    }


}
