package com.snapbug.mappers;

import com.snapbug.dtos.ModuleCreationDTO;
import com.snapbug.dtos.ModuleDTO;
import com.snapbug.entities.Module;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ModuleMapper {
  Module dtoToModel(ModuleCreationDTO module);
  Module dtoToModel(ModuleDTO module);
  ModuleDTO modelToDto(Module module);
}
