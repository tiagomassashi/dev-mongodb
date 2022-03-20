package br.com.nagata.dev.model.dto;

import br.com.nagata.dev.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private String id;
  private String name;
  private String email;

  public UserDTO(User entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.email = entity.getEmail();
  }
}
