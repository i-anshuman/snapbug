package com.snapbug.services;

import com.snapbug.dtos.RoleCreationDTO;
import com.snapbug.dtos.RoleDTO;
import com.snapbug.dtos.RoleDetailsDTO;
import com.snapbug.dtos.RolePermissionDTO;

import java.util.List;

public interface IRoleService {
  RoleDTO save(RoleCreationDTO role);
  List<RoleDTO> getAll();
  RoleDetailsDTO getById(Long roleId);
  void delete(Long roleId);
  RoleDTO update(RoleDTO role);
  RoleDetailsDTO addPermission(RolePermissionDTO rolePermission);
  RoleDetailsDTO removePermission(RolePermissionDTO rolePermission);
}
