package com.snapbug.services;

import com.snapbug.dtos.SubModuleCreationDTO;
import com.snapbug.dtos.SubModuleDTO;
import com.snapbug.entities.SubModule;
import com.snapbug.mappers.SubModuleMapper;
import com.snapbug.repositories.ISubModuleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SubModuleService implements ISubModuleService {

  private final ISubModuleRepository subModuleRepository;
  private final SubModuleMapper subModuleMapper;

  public SubModuleService(ISubModuleRepository subModuleRepository, SubModuleMapper subModuleMapper) {
    this.subModuleRepository = subModuleRepository;
    this.subModuleMapper = subModuleMapper;
  }

  @Override
  public SubModuleDTO save(SubModuleCreationDTO subModule) {
    final SubModule model = subModuleRepository.save(subModuleMapper.dtoToModel(subModule));
    return subModuleMapper.modelToDto(model);
  }

  @Override
  public List<SubModuleDTO> getAll() {
    return subModuleRepository
            .getAll()
            .stream()
            .toList();
  }

  @Override
  public List<SubModuleDTO> getAll(Long moduleId) {
    return subModuleRepository
            .getByModule(moduleId)
            .stream()
            .toList();
  }

  @Override
  public void delete(Long subModuleId) {
    subModuleRepository.deleteById(subModuleId);
  }

  @Override
  public SubModuleDTO update(SubModuleDTO subModule) {
    final SubModule model = subModuleRepository.save(subModuleMapper.dtoToModel(subModule));
    return subModuleMapper.modelToDto(model);
  }
}
