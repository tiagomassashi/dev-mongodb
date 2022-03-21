package br.com.nagata.dev.service;

import br.com.nagata.dev.model.Post;
import br.com.nagata.dev.repository.PostRepository;
import br.com.nagata.dev.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
  private final PostRepository repository;

  @Autowired
  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public Post findById(String id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

  public List<Post> findByTitle(String text) {
    return repository.searchTitle(text);
  }
}
