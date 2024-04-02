package com.snapbug.services;

import com.snapbug.dtos.ModuleCreationDTO;
import com.snapbug.dtos.ModuleDTO;

import java.util.List;

public interface IModuleService {
  ModuleDTO save(ModuleCreationDTO module);
  List<ModuleDTO> getAll();
  void delete(Long moduleId);
  ModuleDTO update(ModuleDTO module);
}
