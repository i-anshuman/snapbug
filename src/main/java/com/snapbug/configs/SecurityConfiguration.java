package com.snapbug.configs;

import com.snapbug.security.AuthTokenFilter;
import com.snapbug.security.IJwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  private final AuthenticationEntryPoint authenticationEntryPoint;
  private final IJwtUtil jwtUtil;
  private final UserDetailsService userDetailsService;

  @Autowired
  public SecurityConfiguration(AuthenticationEntryPoint authenticationEntryPoint, UserDetailsService userDetailsService, IJwtUtil jwtUtil) {
    this.authenticationEntryPoint = authenticationEntryPoint;
    this.userDetailsService = userDetailsService;
    this.jwtUtil = jwtUtil;
  }

  @Bean
  public AuthTokenFilter getAuthTokenFilter(IJwtUtil jwtUtil, UserDetailsService userDetailsService) {
    return new AuthTokenFilter(jwtUtil, userDetailsService);
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService);
    authenticationProvider.setPasswordEncoder(passwordEncoder);
    return new ProviderManager(authenticationProvider);
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
            .cors(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
            .formLogin(FormLoginConfigurer::disable)
            .httpBasic(config -> config.authenticationEntryPoint(authenticationEntryPoint))
            .authorizeHttpRequests(authorize ->
              authorize
                .requestMatchers("/admin/**", "/docs/**", "/swagger-ui/**").hasAuthority("Admin")
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(getAuthTokenFilter(jwtUtil, userDetailsService), UsernamePasswordAuthenticationFilter.class)
            .build();
  }
}
