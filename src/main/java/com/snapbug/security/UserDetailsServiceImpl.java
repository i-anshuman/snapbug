package com.snapbug.security;

import com.snapbug.entities.User;
import com.snapbug.repositories.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

  private final IUserRepository userRepository;

  @Value("${global.security.credential.invalid}")
  private String invalidCredential;

  @Autowired
  public UserDetailsServiceImpl(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final User user = userRepository
                        .findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException(invalidCredential));

    final List<? extends GrantedAuthority> authorities = user.getRole()
                                                             .getPermissions()
                                                             .stream()
                                                             .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                                                             .toList();
    return UserDetailsImpl.builder()
            .id(user.getId())
            .email(user.getEmail())
            .username(user.getUsername())
            .password(user.getPassword())
            .authorities(authorities)
            .build();
  }
}
