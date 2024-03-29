package com.snapbug.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class IssueException extends RuntimeException {

  private HttpStatus status;

  public IssueException(String message) {
    super(message);
  }

  public IssueException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }
}
