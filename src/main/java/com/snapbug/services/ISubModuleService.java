package com.snapbug.services;

import com.snapbug.dtos.SubModuleCreationDTO;
import com.snapbug.dtos.SubModuleDTO;

import java.util.List;

public interface ISubModuleService {
  SubModuleDTO save(SubModuleCreationDTO subModule);
  List<SubModuleDTO> getAll();
  List<SubModuleDTO> getAll(Long moduleId);
  void delete(Long subModuleId);
  SubModuleDTO update(SubModuleDTO subModule);
}
