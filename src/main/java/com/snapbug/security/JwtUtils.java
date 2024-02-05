package com.snapbug.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils implements IJwtUtil {

  private static final Logger log = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${security.jwt.secret}")
  private String secret;

  @Value("${security.jwt.validity}")
  private int validity;

  @Value("${security.jwt.issuer}")
  private String issuer;

  @Override
  public Claims getAllClaims(String token) {
    return Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJwt(token)
            .getBody();
  }

  @Override
  public <T> T getClaim(String token, Function<Claims, T> resolver) {
    return resolver.apply(this.getAllClaims(token));
  }

  @Override
  public String getSubject(String token) {
    return this.getClaim(token, Claims::getSubject);
  }

  @Override
  public Date getExpirationTime(String token) {
    return this.getClaim(token, Claims::getExpiration);
  }

  @Override
  public Date getIssueTime(String token) {
    return this.getClaim(token, Claims::getIssuedAt);
  }

  @Override
  public String getIssuer(String token) {
    return this.getClaim(token, Claims::getIssuer);
  }

  @Override
  public String generateToken(UserDetails user) {
    Map<String, Object> claims = new HashMap<>();
    claims.put("role", user.getAuthorities());
    return Jwts.builder()
            .setSubject(user.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + validity))
            .setNotBefore(new Date())
            .setClaims(claims)
            .setIssuer(issuer)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
  }

  @Override
  public boolean isValidToken(String token) {
    try {
      this.getAllClaims(token);
      return true;
    }
    catch (SignatureException ex) {
      log.error("Invalid JWT signature: {} ", ex.getMessage());
    }
    catch (MalformedJwtException ex) {
      log.error("Invalid JWT token: {} ", ex.getMessage());
    }
    catch (ExpiredJwtException ex) {
      log.error("JWT token is expired: {} ", ex.getMessage());
    }
    catch (UnsupportedJwtException ex) {
      log.error("JWT token is unsupported: {} ", ex.getMessage());
    }
    catch (IllegalArgumentException ex) {
      log.error("JWT claims string is empty: {} ", ex.getMessage());
    }
    return false;
  }
}
