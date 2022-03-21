package br.com.nagata.dev.model;

import br.com.nagata.dev.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id private String id;
  private String name;
  private String email;

  @DBRef(lazy = true)
  private List<Post> posts;

  public User(UserDTO dto) {
    this.name = dto.getName();
    this.email = dto.getEmail();
  }
}
