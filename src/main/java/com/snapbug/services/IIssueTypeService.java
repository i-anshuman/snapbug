package com.snapbug.services;

import com.snapbug.dtos.IssueTypeCreationDTO;
import com.snapbug.dtos.IssueTypeDTO;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IIssueTypeService {

  @PreAuthorize("hasAuthority('issuetype:create')")
  IssueTypeDTO save(IssueTypeCreationDTO issueType);

  @PreAuthorize("hasAuthority('issuetype:read')")
  List<IssueTypeDTO> getAll();

  @PreAuthorize("hasAuthority('issuetype:delete')")
  void delete(Long issueTypeId);

  @PreAuthorize("hasAuthority('issuetype:update')")
  IssueTypeDTO update(IssueTypeDTO issueType);
}
