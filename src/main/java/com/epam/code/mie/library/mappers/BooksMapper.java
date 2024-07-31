package com.epam.code.mie.library.mappers;

import com.epam.code.mie.library.dtos.BookDto;
import com.epam.code.mie.library.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BooksMapper implements Mapper<BookDto, Book> {

  private final AuthorMapper authorMapper;

  public BookDto toDto(Book entity) {
    return new BookDto(entity.getName(),
        authorMapper.toDto(entity.getAuthor()), entity.getGenre(),
        entity.getDescription());
  }

  public Book toEntity(BookDto dto) {
    return new Book(dto.getName(),
        authorMapper.toEntity(dto.getAuthor()), dto.getGenre(),
        dto.getDescription());
  }

}