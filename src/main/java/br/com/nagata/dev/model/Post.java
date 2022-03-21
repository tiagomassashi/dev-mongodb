package br.com.nagata.dev.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "post")
public class Post implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id private String id;
  private LocalDate date;
  private String title;
  private String body;
  private User author;
}
