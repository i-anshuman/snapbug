package com.snapbug.services;

import com.snapbug.dtos.AssignmentDTO;
import com.snapbug.entities.Assignment;
import com.snapbug.mappers.AssignmentMapper;
import com.snapbug.repositories.IAssignmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AssignmentService implements IAssignmentService {

  private final IAssignmentRepository assignmentRepository;
  private final AssignmentMapper assignmentMapper;

  @Autowired
  public AssignmentService(IAssignmentRepository assignmentRepository, AssignmentMapper assignmentMapper) {
    this.assignmentRepository = assignmentRepository;
    this.assignmentMapper = assignmentMapper;
  }

  @Override
  public AssignmentDTO assign(AssignmentDTO assignment) {
    final Assignment model = assignmentRepository.save(assignmentMapper.dtoToModel(assignment));
    return assignmentMapper.modelToDto(model);
  }
}
