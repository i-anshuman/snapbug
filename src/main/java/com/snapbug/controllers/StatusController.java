package com.snapbug.controllers;

import com.snapbug.dtos.StatusCreationDTO;
import com.snapbug.dtos.StatusDTO;
import com.snapbug.services.IStatusService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = "/status")
public class StatusController {

  private static final Logger log = LoggerFactory.getLogger(StatusController.class);

  private final IStatusService statusService;

  @Autowired
  public StatusController(IStatusService statusService) {
    this.statusService = statusService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<StatusDTO> create(@RequestBody @Valid StatusCreationDTO status) {
    final StatusDTO model = statusService.save(status);
    log.info("[POST /status]: New status created: {}", model);
    return ResponseEntity.status(HttpStatus.CREATED).body(model);
  }

  @GetMapping(path = "/")
  public ResponseEntity<List<StatusDTO>> getAll() {
    final List<StatusDTO> status = statusService.getAll();
    log.info("[GET /status]: {} status found.", status.size());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(status);
  }

  @DeleteMapping(path = "/{statusId}")
  public ResponseEntity<StatusDTO> delete(@PathVariable Long statusId) {
    statusService.delete(statusId);
    log.info("[DELETE /status/{}]: Status deleted.", statusId);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(StatusDTO.builder().id(statusId).build());
  }

  @PatchMapping(path = "/")
  public ResponseEntity<StatusDTO> update(@RequestBody @Valid StatusDTO status) {
    final StatusDTO model = statusService.update(status);
    log.info("[PATCH /status]: Status updated: {}", model);
    return ResponseEntity.status(HttpStatus.OK).body(model);
  }
}
