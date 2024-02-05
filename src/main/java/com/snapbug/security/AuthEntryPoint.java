package com.snapbug.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint {

  private static final Logger log = LoggerFactory.getLogger(AuthEntryPoint.class);

  @Value("${global.security.unauthorized}")
  private String unauthorizedRequest;

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
    log.error("Unauthorized request: {}.", authException.getMessage());
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, unauthorizedRequest);
  }
}
