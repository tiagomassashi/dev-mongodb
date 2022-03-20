package br.com.nagata.dev.service;

import br.com.nagata.dev.model.User;
import br.com.nagata.dev.model.dto.UserDTO;
import br.com.nagata.dev.repository.UserRepository;
import br.com.nagata.dev.service.exception.ObjectNotFoundException;
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

  public User findById(String id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
  }

  public User insert(UserDTO userDto) {
    return repository.save(new User(userDto));
  }

  public void delete(String id) {
    findById(id);
    repository.deleteById(id);
  }

  public void update(User user) {
    User newUser = findById(user.getId());
    updateData(newUser, user);
    repository.save(newUser);
  }

  private void updateData(User newUser, User user) {
    newUser.setName(user.getName());
    newUser.setEmail(user.getEmail());
  }
}
