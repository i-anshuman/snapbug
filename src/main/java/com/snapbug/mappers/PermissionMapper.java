package com.snapbug.mappers;

import com.snapbug.dtos.PermissionCreationDTO;
import com.snapbug.dtos.PermissionDTO;
import com.snapbug.entities.Permission;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PermissionMapper {
  Permission dtoToModel(PermissionCreationDTO permission);
  Permission dtoToModel(PermissionDTO permission);
  PermissionDTO modelToDto(Permission permission);
}
