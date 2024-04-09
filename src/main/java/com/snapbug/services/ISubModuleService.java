package com.snapbug.services;

import com.snapbug.dtos.SubModuleCreationDTO;
import com.snapbug.dtos.SubModuleDTO;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface ISubModuleService {

  @PreAuthorize("hasAuthority('submodule:create')")
  SubModuleDTO save(SubModuleCreationDTO subModule);

  @PreAuthorize("hasAuthority('submodule:read')")
  List<SubModuleDTO> getAll();

  @PreAuthorize("hasAuthority('submodule:read')")
  List<SubModuleDTO> getAll(Long moduleId);

  @PreAuthorize("hasAuthority('submodule:delete')")
  void delete(Long subModuleId);

  @PreAuthorize("hasAuthority('submodule:update')")
  SubModuleDTO update(SubModuleDTO subModule);
}
