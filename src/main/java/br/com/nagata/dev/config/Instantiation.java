package br.com.nagata.dev.config;

import br.com.nagata.dev.model.User;
import br.com.nagata.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
  private final UserRepository repository;

  @Autowired
  public Instantiation(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) {
    repository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    repository.saveAll(Arrays.asList(maria, alex, bob));
  }
}
