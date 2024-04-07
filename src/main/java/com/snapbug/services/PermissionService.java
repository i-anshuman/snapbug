package com.snapbug.services;

import com.snapbug.dtos.PermissionCreationDTO;
import com.snapbug.dtos.PermissionDTO;
import com.snapbug.entities.Permission;
import com.snapbug.mappers.PermissionMapper;
import com.snapbug.repositories.IPermissionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PermissionService implements IPermissionService {

  private final IPermissionRepository permissionRepository;
  private final PermissionMapper permissionMapper;

  public PermissionService(IPermissionRepository permissionRepository, PermissionMapper permissionMapper) {
    this.permissionRepository = permissionRepository;
    this.permissionMapper = permissionMapper;
  }


  @Override
  public PermissionDTO save(PermissionCreationDTO permission) {
    final Permission model = permissionRepository.save(permissionMapper.dtoToModel(permission));
    return permissionMapper.modelToDto(model);
  }

  @Override
  public List<PermissionDTO> getAll() {
    return permissionRepository
            .findAll()
            .stream()
            .map(permissionMapper::modelToDto)
            .toList();
  }

  @Override
  public void delete(Long permissionId) {
    permissionRepository.deleteById(permissionId);
  }

  @Override
  public PermissionDTO update(PermissionDTO permission) {
    final Permission model = permissionRepository.save(permissionMapper.dtoToModel(permission));
    return permissionMapper.modelToDto(model);
  }
}
