package br.com.nagata.dev.service;

import br.com.nagata.dev.model.User;
import br.com.nagata.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository repository;

  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<User> findAll() {
    return repository.findAll();
  }
}
