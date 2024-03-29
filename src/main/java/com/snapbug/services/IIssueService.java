package com.snapbug.services;

import com.snapbug.dtos.IssueCreationDTO;
import com.snapbug.dtos.IssueDTO;
import com.snapbug.dtos.IssueDetailDTO;
import com.snapbug.dtos.IssueListDTO;
import com.snapbug.dtos.PageDTO;
import com.snapbug.entities.Issue;
import com.snapbug.entities.User;

import java.util.List;

public interface IIssueService {
  IssueDTO create(IssueCreationDTO issue);
  void delete(Long id);
  PageDTO<List<IssueListDTO>> getAll(int page, int size);
  IssueDetailDTO getIssue(Long issueId);
  List<Issue> getByReporter(User reporter);
}
