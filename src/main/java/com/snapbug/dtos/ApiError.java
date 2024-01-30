package com.snapbug.dtos;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
public class ApiError {

  private HttpStatus status;
  private String message;
  private String localizedMessage;
  private Map<String, String> fieldErrors;
  private Map<String, String> globalErrors;
  private LocalDateTime timestamp;
}