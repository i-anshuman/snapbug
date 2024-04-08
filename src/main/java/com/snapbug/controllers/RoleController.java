package com.snapbug.controllers;

import com.snapbug.dtos.RoleCreationDTO;
import com.snapbug.dtos.RoleDTO;
import com.snapbug.dtos.RoleDetailsDTO;
import com.snapbug.dtos.RolePermissionDTO;
import com.snapbug.services.IRoleService;
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
@RequestMapping(path = "/role")
public class RoleController {

  private static final Logger log = LoggerFactory.getLogger(RoleController.class);

  private final IRoleService roleService;

  public RoleController(IRoleService roleService) {
    this.roleService = roleService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<RoleDTO> create(@RequestBody @Valid RoleCreationDTO role) {
    final RoleDTO model = roleService.save(role);
    log.info("[POST /role]: New role created: {}", model);
    return ResponseEntity.status(HttpStatus.CREATED).body(model);
  }

  @GetMapping(path = "/")
  public ResponseEntity<List<RoleDTO>> getAll() {
    final List<RoleDTO> roles = roleService.getAll();
    log.info("[GET /role]: {} roles found.", roles.size());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(roles);
  }

  @GetMapping(path = "/{roleId}")
  public ResponseEntity<RoleDetailsDTO> getById(@PathVariable Long roleId) {
    final RoleDetailsDTO role = roleService.getById(roleId);
    log.info("[GET /role/{}]: Roles found: {}.", roleId, role);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(role);
  }

  @DeleteMapping(path = "/{roleId}")
  public ResponseEntity<RoleDTO> delete(@PathVariable Long roleId) {
    roleService.delete(roleId);
    log.info("[DELETE /role/{}]: Role deleted.", roleId);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(RoleDTO.builder().id(roleId).build());
  }

  @PatchMapping(path = "/")
  public ResponseEntity<RoleDTO> update(@RequestBody @Valid RoleDTO role) {
    final RoleDTO model = roleService.update(role);
    log.info("[PATCH /role]: Role updated: {}", model);
    return ResponseEntity.status(HttpStatus.OK).body(model);
  }

  @PostMapping(path = "/permission")
  public ResponseEntity<RoleDetailsDTO> addPermission(@RequestBody @Valid RolePermissionDTO rolePermission) {
    final RoleDetailsDTO role = roleService.addPermission(rolePermission);
    log.info("[POST /role/permission]: Permission granted: {}", role);
    return ResponseEntity.status(HttpStatus.CREATED).body(role);
  }

  @DeleteMapping(path = "/permission")
  public ResponseEntity<RoleDetailsDTO> removePermission(@RequestBody @Valid RolePermissionDTO rolePermission) {
    final RoleDetailsDTO role = roleService.removePermission(rolePermission);
    log.info("[DELETE /role/permission]: Permission revoked: {}", role);
    return ResponseEntity.status(HttpStatus.CREATED).body(role);
  }
}
