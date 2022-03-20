package br.com.nagata.dev.controller;

import br.com.nagata.dev.model.User;
import br.com.nagata.dev.model.dto.UserDTO;
import br.com.nagata.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody UserDTO dto) {
    User user = service.insert(dto);
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri();
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO dto) {
    User user = new User(dto);
    user.setId(id);
    service.update(user);
    return ResponseEntity.noContent().build();
  }
}
