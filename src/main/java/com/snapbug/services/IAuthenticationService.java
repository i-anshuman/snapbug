package com.snapbug.services;

import com.snapbug.dtos.AuthenticatedUserDTO;
import com.snapbug.dtos.AuthenticationDTO;

public interface IAuthenticationService {
  AuthenticatedUserDTO authenticate(AuthenticationDTO auth);
}
