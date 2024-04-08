package com.snapbug.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PermissionException extends RuntimeException {
  private HttpStatus status;

  public PermissionException(String message) {
    super(message);
  }

  public PermissionException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }
}
