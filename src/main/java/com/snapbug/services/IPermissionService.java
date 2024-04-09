package com.snapbug.services;

import com.snapbug.dtos.PermissionCreationDTO;
import com.snapbug.dtos.PermissionDTO;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IPermissionService {

  @PreAuthorize("hasAuthority('permission:create')")
  PermissionDTO save(PermissionCreationDTO permission);

  @PreAuthorize("hasAuthority('permission:read')")
  List<PermissionDTO> getAll();

  @PreAuthorize("hasAuthority('permission:delete')")
  void delete(Long permissionId);

  @PreAuthorize("hasAuthority('permission:update')")
  PermissionDTO update(PermissionDTO permission);
}
