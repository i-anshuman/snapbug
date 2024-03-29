package com.snapbug.mappers;

import com.snapbug.dtos.IssueCreationDTO;
import com.snapbug.dtos.IssueDTO;
import com.snapbug.entities.Issue;
import com.snapbug.entities.IssueType;
import com.snapbug.entities.Screen;
import com.snapbug.entities.Severity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IssueMapper {

  @Mapping(source = "screen", target = "screen", qualifiedByName = "getScreenById")
  @Mapping(source = "type", target = "type", qualifiedByName = "getIssueTypeById")
  @Mapping(source = "severity", target = "severity", qualifiedByName = "getSeverityById")
  Issue dtoToModel(IssueCreationDTO issue);

  IssueDTO modelToDto(Issue issue);

  @Named("getScreenById")
  default Screen getScreenById(Long screen) {
    return Screen.builder()
            .id(screen)
            .build();
  }

  @Named("getIssueTypeById")
  default IssueType getIssueTypeById(Long type) {
    return IssueType.builder()
            .id(type)
            .build();
  }

  @Named("getSeverityById")
  default Severity getSeverityById(Long severity) {
    return Severity.builder()
            .id(severity)
            .build();
  }
}
