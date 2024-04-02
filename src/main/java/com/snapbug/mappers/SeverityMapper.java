package com.snapbug.mappers;

import com.snapbug.dtos.SeverityCreationDTO;
import com.snapbug.dtos.SeverityDTO;
import com.snapbug.entities.Severity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface SeverityMapper {
  Severity dtoToModel(SeverityDTO severity);
  Severity dtoToModel(SeverityCreationDTO severity);
  SeverityDTO modelToDto(Severity severity);
}
