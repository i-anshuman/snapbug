package com.snapbug.services;

import com.snapbug.dtos.AssignmentDTO;
import org.springframework.security.access.prepost.PreAuthorize;

public interface IAssignmentService {
  @PreAuthorize("hasAuthority('assignment:create')")
  AssignmentDTO assign(AssignmentDTO assignment);
}
