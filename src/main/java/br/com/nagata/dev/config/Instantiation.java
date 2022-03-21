package br.com.nagata.dev.config;

import br.com.nagata.dev.model.Post;
import br.com.nagata.dev.model.User;
import br.com.nagata.dev.repository.PostRepository;
import br.com.nagata.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
  private final UserRepository userRepository;
  private final PostRepository postRepository;

  @Autowired
  public Instantiation(UserRepository repository, PostRepository postRepository) {
    this.userRepository = repository;
    this.postRepository = postRepository;
  }

  @Override
  public void run(String... args) {
    userRepository.deleteAll();
    postRepository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    Post post1 =
        new Post(
            null,
            LocalDate.of(2018, 3, 21),
            "Partiu viagem",
            "Vou viajar para São Paulo. Abraços!",
            maria);

    Post post2 = new Post(null, LocalDate.of(2018, 3, 23), "Bom dia", "Acordei feliz hoje!", maria);

    userRepository.saveAll(Arrays.asList(maria, alex, bob));
    postRepository.saveAll(Arrays.asList(post1, post2));
  }
}
