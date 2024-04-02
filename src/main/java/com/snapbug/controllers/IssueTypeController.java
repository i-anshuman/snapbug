package com.snapbug.controllers;

import com.snapbug.dtos.IssueTypeCreationDTO;
import com.snapbug.dtos.IssueTypeDTO;
import com.snapbug.services.IIssueTypeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/issue-type")
public class IssueTypeController {

  private static final Logger log = LoggerFactory.getLogger(IssueTypeController.class);

  private final IIssueTypeService issueTypeService;

  public IssueTypeController(IIssueTypeService issueTypeService) {
    this.issueTypeService = issueTypeService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<IssueTypeDTO> create(@RequestBody @Valid IssueTypeCreationDTO issueType) {
    final IssueTypeDTO model = issueTypeService.save(issueType);
    log.info("[POST /issue-type]: New issue type created: {}", model);
    return ResponseEntity.status(HttpStatus.CREATED).body(model);
  }

  @GetMapping(path = "/")
  public ResponseEntity<List<IssueTypeDTO>> getAll() {
    final List<IssueTypeDTO> issueTypes = issueTypeService.getAll();
    log.info("[GET /issue-type]: {} issue types found.", issueTypes.size());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(issueTypes);
  }

  @DeleteMapping(path = "/{issueTypeId}")
  public ResponseEntity<IssueTypeDTO> delete(@PathVariable Long issueTypeId) {
    issueTypeService.delete(issueTypeId);
    log.info("[DELETE /issue-type/{}]: Issue type deleted.", issueTypeId);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(IssueTypeDTO.builder().id(issueTypeId).build());
  }

  @PatchMapping(path = "/")
  public ResponseEntity<IssueTypeDTO> update(@RequestBody @Valid IssueTypeDTO issueType) {
    final IssueTypeDTO model = issueTypeService.update(issueType);
    log.info("[PATCH /issue-type]: Issue type updated: {}", model);
    return ResponseEntity.status(HttpStatus.OK).body(model);
  }
}
