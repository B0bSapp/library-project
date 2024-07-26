package com.epam.code.mie.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "library", name = "books")
public class Book {

  @Id
  @GeneratedValue(
      strategy = GenerationType.IDENTITY
  )

  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "author_id", nullable = false)
  private Author author;

  private String genre;

  private String description;

}
