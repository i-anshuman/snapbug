package com.snapbug.services;

import com.snapbug.dtos.IssueCreationDTO;
import com.snapbug.dtos.IssueDTO;
import com.snapbug.dtos.IssueDetailDTO;
import com.snapbug.dtos.IssueListDTO;
import com.snapbug.dtos.PageDTO;
import com.snapbug.entities.Issue;
import com.snapbug.entities.User;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface IIssueService {

  @PreAuthorize("hasAuthority('issue:create')")
  IssueDTO create(IssueCreationDTO issue);

  @PreAuthorize("hasAuthority('issue:delete')")
  void delete(Long id);

  @PreAuthorize("hasAuthority('issue:read')")
  PageDTO<List<IssueListDTO>> getAll(int page, int size);

  @PreAuthorize("hasAuthority('issue:read')")
  IssueDetailDTO getIssue(Long issueId);

  @PreAuthorize("hasAuthority('issue:read')")
  List<Issue> getByReporter(User reporter);
}
