package br.com.nagata.dev.model.dto;

import br.com.nagata.dev.model.User;
import lombok.Data;

@Data
public class UserDTO {
  private String id;
  private String name;
  private String email;

  public UserDTO(User entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.email = entity.getEmail();
  }
}
