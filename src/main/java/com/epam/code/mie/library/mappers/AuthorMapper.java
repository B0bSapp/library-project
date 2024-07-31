package com.epam.code.mie.library.mappers;

import com.epam.code.mie.library.dtos.AuthorDto;
import com.epam.code.mie.library.entities.Author;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthorMapper implements Mapper<AuthorDto, Author> {

  public AuthorDto toDto(Author author) {
    return new AuthorDto(author.getName(), author.getLastName(), author.getSecondName(), List.of());
  }

  public Author toEntity(AuthorDto authorDto) {
    Author author = new Author();
    author.setName(authorDto.getName());
    author.setLastName(authorDto.getLastName());
    author.setSecondName(authorDto.getSecondName());
    // Assuming you might need to set books or other fields if applicable
    return author;
  }
}