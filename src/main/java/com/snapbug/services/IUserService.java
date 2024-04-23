package com.snapbug.services;

import com.snapbug.dtos.UserCreationDTO;
import com.snapbug.dtos.UserDTO;
import com.snapbug.dtos.UserListDTO;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IUserService {
  @PreAuthorize("hasAuthority('user:create')")
  UserDTO create(UserCreationDTO user);

  @PreAuthorize("hasAuthority('user:read')")
  List<UserListDTO> getAll();
}
