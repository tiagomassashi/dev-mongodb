package br.com.nagata.dev.controller;

import br.com.nagata.dev.model.dto.UserDTO;
import br.com.nagata.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService service;

  @Autowired
  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<UserDTO>> findAll() {
    return ResponseEntity.ok(
        service.findAll().stream().map(UserDTO::new).collect(Collectors.toList()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable() String id) {
    return ResponseEntity.ok(new UserDTO(service.findById(id)));
  }
}
