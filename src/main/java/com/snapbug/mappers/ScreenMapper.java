package com.snapbug.mappers;

import com.snapbug.dtos.ScreenCreationDTO;
import com.snapbug.dtos.ScreenDTO;
import com.snapbug.entities.Screen;
import com.snapbug.entities.SubModule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = SubModuleMapper.class)
public interface ScreenMapper {
  @Mapping(source = "subModule", target = "subModule", qualifiedByName = "getSubModuleById")
  Screen dtoToModel(ScreenCreationDTO screen);
  Screen dtoToModel(ScreenDTO screen);
  ScreenDTO modelToDto(Screen screen);

  @Named("getSubModuleById")
  default SubModule getSubModuleById(Long subModuleId) {
    return SubModule.builder().id(subModuleId).build();
  }
}
