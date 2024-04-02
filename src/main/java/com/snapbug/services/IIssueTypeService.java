package com.snapbug.services;

import com.snapbug.dtos.IssueTypeCreationDTO;
import com.snapbug.dtos.IssueTypeDTO;

import java.util.List;

public interface IIssueTypeService {
  IssueTypeDTO save(IssueTypeCreationDTO issueType);
  List<IssueTypeDTO> getAll();
  void delete(Long issueTypeId);
  IssueTypeDTO update(IssueTypeDTO issueType);
}
