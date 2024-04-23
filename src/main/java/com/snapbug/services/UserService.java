package com.snapbug.services;

import com.snapbug.dtos.UserCreationDTO;
import com.snapbug.dtos.UserDTO;
import com.snapbug.dtos.UserListDTO;
import com.snapbug.entities.User;
import com.snapbug.exceptions.UserException;
import com.snapbug.mappers.UserMapper;
import com.snapbug.repositories.IUserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {

  private static final Logger log = LoggerFactory.getLogger(UserService.class);

  private final IUserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserMapper userMapper;

  @Value("${validation.user.username.exists}")
  private String usernameAlreadyExists;

  @Value("${validation.user.email.exists}")
  private String emailAlreadyExists;

  @Value("${validation.role.invalid}")
  private String invalidRole;

  @Autowired
  public UserService(IUserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.userMapper = userMapper;
  }

  @Override
  public UserDTO create(UserCreationDTO userDto) {
    if(userRepository.existsByUsername(userDto.getUsername())) {
      log.info("[create]: Validation error: {}", usernameAlreadyExists);
      throw new UserException(usernameAlreadyExists, HttpStatus.CONFLICT);
    }
    if(userRepository.existsByEmail(userDto.getEmail())) {
      log.info("[create]: Validation error: {}", emailAlreadyExists);
      throw new UserException(emailAlreadyExists, HttpStatus.CONFLICT);
    }
    final User user = userMapper.dtoToModel(userDto);
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    return userMapper.modelToDto(userRepository.save(user));
  }

  @Override
  public List<UserListDTO> getAll() {
    return userRepository.getAll();
  }
}
