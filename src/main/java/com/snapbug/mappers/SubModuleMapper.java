package com.snapbug.mappers;

import com.snapbug.dtos.SubModuleCreationDTO;
import com.snapbug.dtos.SubModuleDTO;
import com.snapbug.entities.Module;
import com.snapbug.entities.SubModule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = ModuleMapper.class)
public interface SubModuleMapper {
  @Mapping(source = "module", target = "module", qualifiedByName = "getModuleById")
  SubModule dtoToModel(SubModuleCreationDTO subModule);
  SubModule dtoToModel(SubModuleDTO subModule);
  SubModuleDTO modelToDto(SubModule subModule);

  @Named("getModuleById")
  default Module getModuleById(Long moduleId) {
    return Module.builder().id(moduleId).build();
  }
}
