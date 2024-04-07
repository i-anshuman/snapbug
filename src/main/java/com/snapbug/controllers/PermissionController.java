package com.snapbug.controllers;

import com.snapbug.dtos.PermissionCreationDTO;
import com.snapbug.dtos.PermissionDTO;
import com.snapbug.services.IPermissionService;
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
@RequestMapping(path = "/permission")
public class PermissionController {

  private static final Logger log = LoggerFactory.getLogger(PermissionController.class);

  private final IPermissionService permissionService;

  public PermissionController(IPermissionService permissionService) {
    this.permissionService = permissionService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<PermissionDTO> create(@RequestBody @Valid PermissionCreationDTO permission) {
    final PermissionDTO model = permissionService.save(permission);
    log.info("[POST /permission]: New permission created: {}", model);
    return ResponseEntity.status(HttpStatus.CREATED).body(model);
  }

  @GetMapping(path = "/")
  public ResponseEntity<List<PermissionDTO>> getAll() {
    final List<PermissionDTO> permissions = permissionService.getAll();
    log.info("[GET /permission]: {} permissions found.", permissions.size());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(permissions);
  }

  @DeleteMapping(path = "/{permissionId}")
  public ResponseEntity<PermissionDTO> delete(@PathVariable Long permissionId) {
    permissionService.delete(permissionId);
    log.info("[DELETE /permission/{}]: Permission deleted.", permissionId);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(PermissionDTO.builder().id(permissionId).build());
  }

  @PatchMapping(path = "/")
  public ResponseEntity<PermissionDTO> update(@RequestBody @Valid PermissionDTO permission) {
    final PermissionDTO model = permissionService.update(permission);
    log.info("[POST /permission]: Permission updated: {}", model);
    return ResponseEntity.status(HttpStatus.OK).body(model);
  }
}
