package com.snapbug.services;

import com.snapbug.dtos.AuthenticatedUserDTO;
import com.snapbug.dtos.AuthenticationDTO;
import com.snapbug.security.IJwtUtil;
import com.snapbug.security.UserDetailsImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AuthenticationService implements IAuthenticationService {

  private final AuthenticationManager authenticationManager;
  private final IJwtUtil jwtUtil;

  @Autowired
  public AuthenticationService(AuthenticationManager authenticationManager, IJwtUtil jwtUtil) {
    this.authenticationManager = authenticationManager;
    this.jwtUtil = jwtUtil;
  }

  @Override
  public AuthenticatedUserDTO authenticate(AuthenticationDTO auth) {
    final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    final UserDetails principal = (UserDetails) authentication.getPrincipal();
    final String token = jwtUtil.generateToken(principal);
    final List<String> authority = principal
                                    .getAuthorities()
                                    .stream()
                                    .map(GrantedAuthority::getAuthority)
                                    .toList();
    return AuthenticatedUserDTO.builder()
            .id(((UserDetailsImpl)principal).getId())
            .username(principal.getUsername())
            .authority(authority)
            .token(token)
            .build();
  }
}
