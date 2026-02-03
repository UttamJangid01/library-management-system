package com.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lms/user")
public class UserController {

  @GetMapping
  public ResponseEntity<Map<String, String>> Welcome() {
    return ResponseEntity.ok(Map.of("message","Welcome User's Page :)"));
  }

}
