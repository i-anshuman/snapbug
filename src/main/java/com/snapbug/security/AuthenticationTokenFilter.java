package com.snapbug.security;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthenticationTokenFilter extends OncePerRequestFilter {

  private static final Logger log = LoggerFactory.getLogger(AuthenticationTokenFilter.class);

  private final IJwtUtil jwtUtil;
  private final UserDetailsService userDetailsService;

  @Value("${global.security.token}")
  private String tokenNotFound;

  @Value("${global.security.filter}")
  private String filterException;

  @Value("${security.header}")
  private String header;

  @Value("${security.token.prefix}")
  private String prefix;

  public AuthenticationTokenFilter(IJwtUtil jwtUtil, UserDetailsService userDetailsService) {
    this.jwtUtil = jwtUtil;
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    try {
      final String token = getJwtTokenFromAuthorizationHeader(request);
      if (jwtUtil.isValidToken(token)) {
        String username = jwtUtil.getSubject(token);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication =
          UsernamePasswordAuthenticationToken.authenticated(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    catch (Exception ex) {
      log.error("{} {}", filterException, ex.getMessage());
    }
    filterChain.doFilter(request, response);
  }

  private String getJwtTokenFromAuthorizationHeader(HttpServletRequest request) {
    String authHeader = request.getHeader(header);
    if (StringUtils.hasText(authHeader) && authHeader.startsWith(prefix)) {
      return authHeader.substring(7);
    }
    throw new JwtException(tokenNotFound);
  }
}
