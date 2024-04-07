package com.snapbug.services;

import com.snapbug.dtos.PermissionCreationDTO;
import com.snapbug.dtos.PermissionDTO;

import java.util.List;

public interface IPermissionService {
  PermissionDTO save(PermissionCreationDTO permission);
  List<PermissionDTO> getAll();
  void delete(Long permissionId);
  PermissionDTO update(PermissionDTO permission);
}
