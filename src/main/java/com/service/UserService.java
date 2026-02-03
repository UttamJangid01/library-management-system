package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.LoginRequest;
import com.dto.LoginResponse;
import com.dto.SignupRequest;
import com.model.User;
import com.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository repo;

  public String saveUser(SignupRequest signup) {
    if (repo.existsByEmail(signup.getEmail()))
      return "email already registered.";

    User user = new User();
    user.setName(signup.getName());
    user.setEmail(signup.getEmail());
    user.setPassword(signup.getPassword());
    repo.save(user);

    return "User successfully created.";
  }

  public LoginResponse checkUser(LoginRequest login) {
    User user = repo.findByEmail(login.getEmail());

    if (user != null && login.getPassword().equals(user.getPassword()))
      return new LoginResponse("Welcome to Library Management System.", user.getUserId(), user.getName(), true);

    return new LoginResponse("Worng credentials !", null, "null", false);
  }
}
