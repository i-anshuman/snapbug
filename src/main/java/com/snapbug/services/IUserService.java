package com.snapbug.services;

import com.snapbug.dtos.UserCreationDTO;
import com.snapbug.dtos.UserDTO;

public interface IUserService {
  UserDTO create(UserCreationDTO user);
}
