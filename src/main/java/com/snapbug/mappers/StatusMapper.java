package com.snapbug.mappers;

import com.snapbug.dtos.StatusCreationDTO;
import com.snapbug.dtos.StatusDTO;
import com.snapbug.entities.Status;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface StatusMapper {
  Status dtoToModel(StatusDTO severity);
  Status dtoToModel(StatusCreationDTO severity);
  StatusDTO modelToDto(Status severity);
}
