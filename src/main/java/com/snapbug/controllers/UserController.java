package com.snapbug.controllers;

import com.snapbug.dtos.UserCreationDTO;
import com.snapbug.dtos.UserDTO;
import com.snapbug.services.IUserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  private static final Logger log = LoggerFactory.getLogger(UserController.class);

  private final IUserService userService;

  @Autowired
  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @PostMapping(path = "/")
  public ResponseEntity<UserDTO> create(@RequestBody @Valid UserCreationDTO userDto) {
    log.info("[POST /user]: User creation: {}", userDto);
    final UserDTO user = userService.create(userDto);
    log.info("[POST /user]: User created: {}", user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
}
