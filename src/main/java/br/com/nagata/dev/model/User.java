package br.com.nagata.dev.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "user")
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id private String id;
  private String name;
  private String email;
}
