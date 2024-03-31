package com.snapbug.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AssignmentException extends RuntimeException {

  private HttpStatus status;

  public AssignmentException(String message) {
    super(message);
  }

  public AssignmentException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }
}
