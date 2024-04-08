package com.snapbug.mappers;

import com.snapbug.dtos.RoleCreationDTO;
import com.snapbug.dtos.RoleDTO;
import com.snapbug.dtos.RoleDetailsDTO;
import com.snapbug.entities.Role;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = PermissionMapper.class)
public interface RoleMapper {
  Role dtoToModel(RoleCreationDTO role);
  Role dtoToModel(RoleDTO role);
  RoleDTO modelToDto(Role role);
  RoleDetailsDTO modelToDetailDto(Role role);
}
