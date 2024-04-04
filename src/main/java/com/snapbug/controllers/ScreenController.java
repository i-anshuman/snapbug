package com.snapbug.controllers;

import com.snapbug.dtos.ScreenCreationDTO;
import com.snapbug.dtos.ScreenDTO;
import com.snapbug.services.IScreenService;
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
@RequestMapping(path = "/screen")
public class ScreenController {
  private static final Logger log = LoggerFactory.getLogger(ScreenController.class);

  private final IScreenService screenService;

  public ScreenController(IScreenService screenService) {
    this.screenService = screenService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<ScreenDTO> create(@RequestBody @Valid ScreenCreationDTO screen) {
    final ScreenDTO model = screenService.save(screen);
    log.info("[POST /screen]: New screen created: {}", model);
    return ResponseEntity.status(HttpStatus.CREATED).body(model);
  }

  @GetMapping(path = "/")
  public ResponseEntity<List<ScreenDTO>> getAll() {
    final List<ScreenDTO> screens = screenService.getAll();
    log.info("[GET /screen]: {} screens found.", screens.size());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(screens);
  }

  @GetMapping(path = "/{subModuleId}")
  public ResponseEntity<List<ScreenDTO>> getAll(@PathVariable Long subModuleId) {
    final List<ScreenDTO> screens = screenService.getAll(subModuleId);
    log.info("[GET /screen/{}]: {} screens found.", subModuleId, screens.size());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(screens);
  }

  @DeleteMapping(path = "/{screenId}")
  public ResponseEntity<ScreenDTO> delete(@PathVariable Long screenId) {
    screenService.delete(screenId);
    log.info("[DELETE /screen/{}]: Screen deleted.", screenId);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(ScreenDTO.builder().id(screenId).build());
  }

  @PatchMapping(path = "/")
  public ResponseEntity<ScreenDTO> update(@RequestBody @Valid ScreenDTO screen) {
    final ScreenDTO model = screenService.update(screen);
    log.info("[POST /screen]: Screen updated: {}", model);
    return ResponseEntity.status(HttpStatus.OK).body(model);
  }
}
