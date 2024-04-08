package com.snapbug.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RoleException extends RuntimeException {

  private HttpStatus status;

  public RoleException(String message) {
    super(message);
  }

  public RoleException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }
}
