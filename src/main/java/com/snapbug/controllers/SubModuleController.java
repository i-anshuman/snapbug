package com.snapbug.controllers;

import com.snapbug.dtos.SubModuleCreationDTO;
import com.snapbug.dtos.SubModuleDTO;
import com.snapbug.services.ISubModuleService;
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
@RequestMapping(path = "/submodule")
public class SubModuleController {
  private static final Logger log = LoggerFactory.getLogger(SubModuleController.class);

  private final ISubModuleService subModuleService;

  public SubModuleController(ISubModuleService subModuleService) {
    this.subModuleService = subModuleService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<SubModuleDTO> create(@RequestBody @Valid SubModuleCreationDTO subModule) {
    final SubModuleDTO model = subModuleService.save(subModule);
    log.info("[POST /submodule]: New submodule created: {}", model);
    return ResponseEntity.status(HttpStatus.CREATED).body(model);
  }

  @GetMapping(path = "/")
  public ResponseEntity<List<SubModuleDTO>> getAll() {
    final List<SubModuleDTO> subModules = subModuleService.getAll();
    log.info("[GET /submodule]: {} submodule found.", subModules.size());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(subModules);
  }

  @GetMapping(path = "/{moduleId}")
  public ResponseEntity<List<SubModuleDTO>> getAll(@PathVariable Long moduleId) {
    final List<SubModuleDTO> subModules = subModuleService.getAll(moduleId);
    log.info("[GET /submodule/{}]: {} submodule found.", moduleId, subModules.size());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(subModules);
  }

  @DeleteMapping(path = "/{subModuleId}")
  public ResponseEntity<SubModuleDTO> delete(@PathVariable Long subModuleId) {
    subModuleService.delete(subModuleId);
    log.info("[DELETE /submodule/{}]: Submodule deleted.", subModuleId);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(SubModuleDTO.builder().id(subModuleId).build());
  }

  @PatchMapping(path = "/")
  public ResponseEntity<SubModuleDTO> update(@RequestBody @Valid SubModuleDTO subModule) {
    final SubModuleDTO model = subModuleService.update(subModule);
    log.info("[POST /submodule]: Submodule updated: {}", model);
    return ResponseEntity.status(HttpStatus.OK).body(model);
  }
}
