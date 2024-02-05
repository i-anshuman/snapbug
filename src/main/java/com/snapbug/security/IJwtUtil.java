package com.snapbug.security;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;

public interface IJwtUtil {

  Claims getAllClaims (String token);
  <T> T getClaim (String token, Function<Claims, T> resolver);
  String getSubject (String token);
  Date getExpirationTime (String token);
  Date getIssueTime (String token);
  String getIssuer (String token);
  String generateToken (UserDetails user);
  boolean isValidToken (String token);
}
