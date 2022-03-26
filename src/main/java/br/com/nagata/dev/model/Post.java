package br.com.nagata.dev.model;

import br.com.nagata.dev.model.dto.AuthorDTO;
import br.com.nagata.dev.model.dto.CommentDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "post")
public class Post implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id private String id;
  private LocalDate date;
  private String title;
  private String body;
  private AuthorDTO author;
  private List<CommentDTO> comments;
}
