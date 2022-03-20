package br.com.nagata.dev.controller;

import br.com.nagata.dev.model.User;
import br.com.nagata.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService service;

  @Autowired
  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}
