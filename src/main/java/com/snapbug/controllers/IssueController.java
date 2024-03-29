package com.snapbug.controllers;

import com.snapbug.dtos.IssueCreationDTO;
import com.snapbug.dtos.IssueDTO;
import com.snapbug.dtos.IssueDetailDTO;
import com.snapbug.dtos.IssueListDTO;
import com.snapbug.dtos.PageDTO;
import com.snapbug.services.IIssueService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/issue")
public class IssueController {

  private static final Logger log = LoggerFactory.getLogger(IssueController.class);

  private final IIssueService issueService;

  @Autowired
  public IssueController(IIssueService issueService) {
    this.issueService = issueService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<IssueDTO> create(@RequestBody @Valid IssueCreationDTO issue) {
    log.info("[POST /issue]: New issue creation: {}", issue);
    final IssueDTO dto = issueService.create(issue);
    log.info("[POST /issue]: New issue created: {}", dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }

  @GetMapping(path = "/")
  public ResponseEntity<PageDTO<List<IssueListDTO>>> getAll(
    @RequestParam(required = false, defaultValue = "1") Integer page,
    @RequestParam(required = false, defaultValue = "10") Integer size
  ) {
    final PageDTO<List<IssueListDTO>> issues = issueService.getAll(page - 1, size);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(issues);
  }

  @GetMapping(path = "/{issueId}")
  public ResponseEntity<IssueDetailDTO> getIssue(@PathVariable Long issueId) {
    final IssueDetailDTO issue = issueService.getIssue(issueId);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(issue);
  }
}
