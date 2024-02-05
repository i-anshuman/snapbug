package com.snapbug.controllers;

import com.snapbug.dtos.AuthenticatedUserDTO;
import com.snapbug.dtos.AuthenticationDTO;
import com.snapbug.services.AuthenticationService;
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
@RequestMapping(path = "/auth")
public class AuthenticationController {

  private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
  
  private final AuthenticationService authenticationService;

  @Autowired
  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<AuthenticatedUserDTO> authenticate(@RequestBody @Valid AuthenticationDTO auth) {
    log.info("[POST /auth]: User authentication: {}", auth);
    final AuthenticatedUserDTO authenticate = authenticationService.authenticate(auth);
    log.info("[POST /auth]: User authenticated: {}", authenticate);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(authenticate);
  }
}
