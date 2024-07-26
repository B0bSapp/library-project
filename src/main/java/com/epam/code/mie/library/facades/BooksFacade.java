package com.epam.code.mie.library.facades;

import com.epam.code.mie.library.dtos.BookDto;
import com.epam.code.mie.library.mappers.BooksMapper;
import com.epam.code.mie.library.services.BooksService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BooksFacade {

  private final BooksService booksService;
  private final BooksMapper booksMapper;

  @Transactional(readOnly = true)
  public List<BookDto> getAllBooks() {
    return booksMapper.toDtoList(booksService.getAllBooks());
  }
}
