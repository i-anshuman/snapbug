package com.snapbug.mappers;

import com.snapbug.dtos.AssignmentDTO;
import com.snapbug.entities.Assignment;
import com.snapbug.entities.Issue;
import com.snapbug.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AssignmentMapper {

  @Mapping(source = "userId", target = "user", qualifiedByName = "getUserById")
  @Mapping(source = "issueId", target = "issue", qualifiedByName = "getIssueById")
  Assignment dtoToModel(AssignmentDTO assignment);

  AssignmentDTO modelToDto(Assignment assignment);

  @Named("getUserById")
  default User getUserById(Long userId) {
    return User.builder()
            .id(userId)
            .build();
  }

  @Named("getIssueById")
  default Issue getIssueById(Long issueId) {
    return Issue.builder()
            .id(issueId)
            .build();
  }
}
