package com.snapbug.services;

import com.snapbug.dtos.ModuleCreationDTO;
import com.snapbug.dtos.ModuleDTO;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IModuleService {

  @PreAuthorize("hasAuthority('module:create')")
  ModuleDTO save(ModuleCreationDTO module);

  @PreAuthorize("hasAuthority('module:read')")
  List<ModuleDTO> getAll();

  @PreAuthorize("hasAuthority('module:delete')")
  void delete(Long moduleId);

  @PreAuthorize("hasAuthority('module:update')")
  ModuleDTO update(ModuleDTO module);
}
