package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.LoginRequest;
import com.dto.LoginResponse;
import com.dto.SignupRequest;
import com.dto.SignupResponse;
import com.service.UserService;

@RestController
@RequestMapping("/lms/auth")
public class AuthController {

  @Autowired
  private UserService service;

  @PostMapping("/signup")
  public SignupResponse Signup(@RequestBody SignupRequest signup) {
    String message = service.saveUser(signup);
    return new SignupResponse(message, signup.getName());
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> Login(@RequestBody LoginRequest login) {
    LoginResponse response = service.checkUser(login);
    System.out.println("status : " + response.getStatus());
    if (response.getStatus())
      return ResponseEntity.ok(response);
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
  }

}
