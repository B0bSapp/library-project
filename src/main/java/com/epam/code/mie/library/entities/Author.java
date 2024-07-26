package com.epam.code.mie.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(schema = "library",
    name = "authors")
public class Author {

  @Id
  @GeneratedValue(
      strategy = GenerationType.IDENTITY
  )

  private Long id;
  private String name;
  private String lastName;
  private String secondName;
  @OneToMany(mappedBy = "author")
  private List<Book> books;
}
