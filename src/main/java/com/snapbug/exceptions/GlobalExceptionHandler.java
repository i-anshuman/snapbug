package com.snapbug.exceptions;

import com.snapbug.dtos.ApiError;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Value("${global.invalid.method.argument}")
  private String invalidMethodArgument;

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    final Map<String, String> fieldErrors = ex.getBindingResult()
                                              .getFieldErrors()
                                              .stream()
                                              .collect(Collectors.toMap(FieldError::getField, error -> Optional.ofNullable(error.getDefaultMessage()).orElse("")));
    final Map<String, String> globalErrors = ex.getBindingResult()
                                               .getGlobalErrors()
                                               .stream()
                                               .collect(Collectors.toMap(ObjectError::getObjectName, error -> Optional.ofNullable(error.getDefaultMessage()).orElse("")));
    ApiError apiError = ApiError.builder()
                          .status(HttpStatus.BAD_REQUEST)
                          .message(invalidMethodArgument)
                          .localizedMessage(ex.getLocalizedMessage())
                          .fieldErrors(fieldErrors)
                          .globalErrors(globalErrors)
                          .timestamp(LocalDateTime.now())
                          .build();
    return handleExceptionInternal( ex, apiError, headers, apiError.getStatus(), request);
  }
}
