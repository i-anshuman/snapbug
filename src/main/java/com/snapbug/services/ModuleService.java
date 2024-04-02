package com.snapbug.services;

import com.snapbug.dtos.ModuleCreationDTO;
import com.snapbug.dtos.ModuleDTO;
import com.snapbug.entities.Module;
import com.snapbug.mappers.ModuleMapper;
import com.snapbug.repositories.IModuleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ModuleService implements IModuleService {

  private final IModuleRepository moduleRepository;
  private final ModuleMapper moduleMapper;

  @Autowired
  public ModuleService(IModuleRepository moduleRepository, ModuleMapper moduleMapper) {
    this.moduleRepository = moduleRepository;
    this.moduleMapper = moduleMapper;
  }

  @Override
  public ModuleDTO save(ModuleCreationDTO module) {
    final Module model = moduleRepository.save(moduleMapper.dtoToModel(module));
    return moduleMapper.modelToDto(model);
  }

  @Override
  public List<ModuleDTO> getAll() {
    return moduleRepository
            .findAll()
            .stream()
            .map(moduleMapper::modelToDto)
            .toList();
  }

  @Override
  public void delete(Long moduleId) {
    moduleRepository.deleteById(moduleId);
  }

  @Override
  public ModuleDTO update(ModuleDTO module) {
    final Module model = moduleRepository.save(moduleMapper.dtoToModel(module));
    return moduleMapper.modelToDto(model);
  }
}
