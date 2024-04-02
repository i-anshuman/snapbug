package com.snapbug.controllers;

import com.snapbug.dtos.ModuleCreationDTO;
import com.snapbug.dtos.ModuleDTO;
import com.snapbug.services.IModuleService;
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
@RequestMapping(path = "/module")
public class ModuleController {

  private static final Logger log = LoggerFactory.getLogger(ModuleController.class);

  private final IModuleService moduleService;

  public ModuleController(IModuleService moduleService) {
    this.moduleService = moduleService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<ModuleDTO> create(@RequestBody @Valid ModuleCreationDTO module) {
    final ModuleDTO model = moduleService.save(module);
    log.info("[POST /module]: New module created: {}", model);
    return ResponseEntity.status(HttpStatus.CREATED).body(model);
  }

  @GetMapping(path = "/")
  public ResponseEntity<List<ModuleDTO>> getAll() {
    final List<ModuleDTO> modules = moduleService.getAll();
    log.info("[GET /module]: {} modules found.", modules.size());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(modules);
  }

  @DeleteMapping(path = "/{moduleId}")
  public ResponseEntity<ModuleDTO> delete(@PathVariable Long moduleId) {
    moduleService.delete(moduleId);
    log.info("[DELETE /module/{}]: Module deleted.", moduleId);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(ModuleDTO.builder().id(moduleId).build());
  }

  @PatchMapping(path = "/")
  public ResponseEntity<ModuleDTO> update(@RequestBody @Valid ModuleDTO module) {
    final ModuleDTO model = moduleService.update(module);
    log.info("[PATCH /module]: Module updated: {}", model);
    return ResponseEntity.status(HttpStatus.OK).body(model);
  }
}
