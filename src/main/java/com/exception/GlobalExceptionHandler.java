package com.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  /*
   * @ExceptionHandler(ResourceNotFoundException.class)
   * public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex){
   * return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
   * }
   */

  @ExceptionHandler(BookNotFoundException.class)
  public ResponseEntity<Map<String, String>> BookHandler(BookNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", ex.getMessage()));
  }

  @ExceptionHandler(MemberNotFoundException.class)
  public ResponseEntity<Map<String, String>> MemberHandler(MemberNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", ex.getMessage()));
  }

  @ExceptionHandler(IssueNotFoundException.class)
  public ResponseEntity<Map<String, String>> IssueHandler(IssueNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", ex.getMessage()));
  }
}
