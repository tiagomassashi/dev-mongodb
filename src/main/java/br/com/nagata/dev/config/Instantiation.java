package br.com.nagata.dev.config;

import br.com.nagata.dev.model.Post;
import br.com.nagata.dev.model.User;
import br.com.nagata.dev.model.dto.AuthorDTO;
import br.com.nagata.dev.model.dto.CommentDTO;
import br.com.nagata.dev.repository.PostRepository;
import br.com.nagata.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    User maria = new User(null, "Maria Brown", "maria@gmail.com", new ArrayList<>());
    User alex = new User(null, "Alex Green", "alex@gmail.com", new ArrayList<>());
    User bob = new User(null, "Bob Grey", "bob@gmail.com", new ArrayList<>());

    userRepository.saveAll(Arrays.asList(maria, alex, bob));

    Post post1 =
        new Post(
            null,
            LocalDate.of(2018, 3, 21),
            "Partiu viagem",
            "Vou viajar para São Paulo. Abraços!",
            new AuthorDTO(maria),
            new ArrayList<>());

    Post post2 =
        new Post(
            null,
            LocalDate.of(2018, 3, 23),
            "Bom dia",
            "Acordei feliz hoje!",
            new AuthorDTO(maria),
            new ArrayList<>());

    CommentDTO comment1 =
        new CommentDTO("Boa viagem mano!", LocalDate.of(2018, 3, 21), new AuthorDTO(alex));
    CommentDTO comment2 =
        new CommentDTO("Aproveite", LocalDate.of(2018, 3, 22), new AuthorDTO(bob));
    CommentDTO comment3 =
        new CommentDTO("Tenha um ótimo dia!", LocalDate.of(2018, 3, 23), new AuthorDTO(alex));

    post1.getComments().addAll(Arrays.asList(comment1, comment2));
    post2.getComments().addAll(List.of(comment3));

    postRepository.saveAll(Arrays.asList(post1, post2));
    maria.getPosts().addAll(Arrays.asList(post1, post2));
    userRepository.save(maria);
  }
}
