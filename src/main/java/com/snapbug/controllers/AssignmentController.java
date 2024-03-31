package com.snapbug.controllers;

import com.snapbug.dtos.AssignmentDTO;
import com.snapbug.services.IAssignmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/assignment")
public class AssignmentController {

  private static final Logger log = LoggerFactory.getLogger(AssignmentController.class);

  private final IAssignmentService assignmentService;

  @Autowired
  public AssignmentController(IAssignmentService assignmentService) {
    this.assignmentService = assignmentService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<AssignmentDTO> assign(@RequestBody @Valid AssignmentDTO assignment) {
    log.info("[POST /assignment]: New assignment: {}", assignment);
    final AssignmentDTO dto = assignmentService.assign(assignment);
    log.info("[POST /assignment]: Issue assigned: {}", dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }
}
