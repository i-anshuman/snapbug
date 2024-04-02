package com.snapbug.mappers;

import com.snapbug.dtos.IssueTypeCreationDTO;
import com.snapbug.dtos.IssueTypeDTO;
import com.snapbug.entities.IssueType;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IssueTypeMapper {
  IssueType dtoToModel(IssueTypeDTO issueType);
  IssueType dtoToModel(IssueTypeCreationDTO issueType);
  IssueTypeDTO modelToDto(IssueType issueType);
}
