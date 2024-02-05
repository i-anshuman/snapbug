package com.snapbug.mappers;

import com.snapbug.dtos.UserCreationDTO;
import com.snapbug.dtos.UserDTO;
import com.snapbug.entities.Role;
import com.snapbug.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {

  @Mapping(source = "role", target = "role", qualifiedByName = "getRoleEntity")
  User dtoToModel(UserCreationDTO user);

  @Mapping(source = "role", target = "role", qualifiedByName = "getRoleName")
  UserDTO modelToDto(User user);

  @Named("getRoleEntity")
  default Role getRoleEntity(Long roleId) {
    return Role.builder().id(roleId).build();
  }

  @Named("getRoleName")
  default String getRoleName(Role role) {
    return role.getName();
  }
}
