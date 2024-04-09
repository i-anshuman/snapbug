package com.snapbug.services;

import com.snapbug.dtos.UserCreationDTO;
import com.snapbug.dtos.UserDTO;
import org.springframework.security.access.prepost.PreAuthorize;

public interface IUserService {
  @PreAuthorize("hasAuthority('user:create')")
  UserDTO create(UserCreationDTO user);
}
