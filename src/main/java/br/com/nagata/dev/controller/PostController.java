package br.com.nagata.dev.controller;

import br.com.nagata.dev.model.Post;
import br.com.nagata.dev.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
  private final PostService service;

  @Autowired
  public PostController(PostService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Post> findById(@PathVariable() String id) {
    return ResponseEntity.ok(service.findById(id));
  }
}
