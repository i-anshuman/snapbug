package com.snapbug.services;

import com.snapbug.dtos.RoleCreationDTO;
import com.snapbug.dtos.RoleDTO;
import com.snapbug.dtos.RoleDetailsDTO;
import com.snapbug.dtos.RolePermissionDTO;
import com.snapbug.entities.Permission;
import com.snapbug.entities.Role;
import com.snapbug.exceptions.PermissionException;
import com.snapbug.exceptions.RoleException;
import com.snapbug.mappers.RoleMapper;
import com.snapbug.repositories.IPermissionRepository;
import com.snapbug.repositories.IRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RoleService implements IRoleService {

  private final IRoleRepository roleRepository;
  private final IPermissionRepository permissionRepository;
  private final RoleMapper roleMapper;

  @Value("${validation.role.invalid}")
  private String invalidRole;

  @Value("${validation.permission.invalid}")
  private String invalidPermission;

  public RoleService(IRoleRepository roleRepository, IPermissionRepository permissionRepository, RoleMapper roleMapper) {
    this.roleRepository = roleRepository;
    this.permissionRepository = permissionRepository;
    this.roleMapper = roleMapper;
  }

  @Override
  public RoleDTO save(RoleCreationDTO role) {
    final Role model = roleRepository.save(roleMapper.dtoToModel(role));
    return roleMapper.modelToDto(model);
  }

  @Override
  public List<RoleDTO> getAll() {
    return roleRepository
            .findAll()
            .stream()
            .map(roleMapper::modelToDto)
            .toList();
  }

  @Override
  public RoleDetailsDTO getById(Long roleId) {
    final Role role = roleRepository
                        .findById(roleId)
                        .orElseThrow(() -> new RoleException(invalidRole));
    return roleMapper.modelToDetailDto(role);
  }

  @Override
  public void delete(Long roleId) {
    roleRepository.deleteById(roleId);
  }

  @Override
  public RoleDTO update(RoleDTO role) {
    final Role model = roleRepository.save(roleMapper.dtoToModel(role));
    return roleMapper.modelToDto(model);
  }

  @Override
  public RoleDetailsDTO addPermission(RolePermissionDTO rolePermission) {
    final Role role = roleRepository
                        .findById(rolePermission.getRoleId())
                        .orElseThrow(() -> new RoleException(invalidRole));
    final Permission permission = permissionRepository
                                    .findById(rolePermission.getPermissionId())
                                    .orElseThrow(() -> new PermissionException(invalidPermission));
    role.getPermissions().add(permission);
    return roleMapper.modelToDetailDto(role);
  }

  @Override
  public RoleDetailsDTO removePermission(RolePermissionDTO rolePermission) {
    final Role role = roleRepository
                        .findById(rolePermission.getRoleId())
                        .orElseThrow(() -> new RoleException(invalidRole));
    role.getPermissions().removeIf(permission -> permission.getId().equals(rolePermission.getPermissionId()));
    return roleMapper.modelToDetailDto(role);
  }
}
