package br.com.nagata.dev.model.dto;

import br.com.nagata.dev.model.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuthorDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private String id;
  private String name;

  public AuthorDTO(User entity) {
    this.id = entity.getId();
    this.name = entity.getName();
  }
}
