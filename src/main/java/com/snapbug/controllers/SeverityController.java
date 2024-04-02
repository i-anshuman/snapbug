package com.snapbug.controllers;

import com.snapbug.dtos.SeverityCreationDTO;
import com.snapbug.dtos.SeverityDTO;
import com.snapbug.services.ISeverityService;
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
@RequestMapping(path = "/severity")
public class SeverityController {

  private static final Logger log = LoggerFactory.getLogger(SeverityController.class);

  private final ISeverityService severityService;

  public SeverityController(ISeverityService severityService) {
    this.severityService = severityService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<SeverityDTO> create(@RequestBody @Valid SeverityCreationDTO severity) {
    final SeverityDTO model = severityService.save(severity);
    log.info("[POST /severity]: New severity created: {}", model);
    return ResponseEntity.status(HttpStatus.CREATED).body(model);
  }

  @GetMapping(path = "/")
  public ResponseEntity<List<SeverityDTO>> getAll() {
    final List<SeverityDTO> severities = severityService.getAll();
    log.info("[GET /severity]: {} severities found.", severities.size());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(severities);
  }

  @DeleteMapping(path = "/{severityId}")
  public ResponseEntity<SeverityDTO> delete(@PathVariable Long severityId) {
    severityService.delete(severityId);
    log.info("[DELETE /severity/{}]: Severity deleted.", severityId);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(SeverityDTO.builder().id(severityId).build());
  }

  @PatchMapping(path = "/")
  public ResponseEntity<SeverityDTO> update(@RequestBody @Valid SeverityDTO severity) {
    final SeverityDTO model = severityService.update(severity);
    log.info("[PATCH /severity]: Severity updated: {}", model);
    return ResponseEntity.status(HttpStatus.OK).body(model);
  }
}
