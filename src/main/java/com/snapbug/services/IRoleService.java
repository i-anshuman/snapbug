package com.snapbug.services;

import com.snapbug.dtos.RoleCreationDTO;
import com.snapbug.dtos.RoleDTO;
import com.snapbug.dtos.RoleDetailsDTO;
import com.snapbug.dtos.RolePermissionDTO;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IRoleService {

  @PreAuthorize("hasAuthority('role:create')")
  RoleDTO save(RoleCreationDTO role);

  @PreAuthorize("hasAuthority('role:read')")
  List<RoleDTO> getAll();

  @PreAuthorize("hasAuthority('role:read')")
  RoleDetailsDTO getById(Long roleId);

  @PreAuthorize("hasAuthority('role:delete')")
  void delete(Long roleId);

  @PreAuthorize("hasAuthority('role:update')")
  RoleDTO update(RoleDTO role);

  @PreAuthorize("hasAuthority('permission:grant')")
  RoleDetailsDTO addPermission(RolePermissionDTO rolePermission);

  @PreAuthorize("hasAuthority('permission:revoke')")
  RoleDetailsDTO removePermission(RolePermissionDTO rolePermission);
}
