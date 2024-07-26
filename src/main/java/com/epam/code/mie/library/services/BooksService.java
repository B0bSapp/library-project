package com.epam.code.mie.library.services;

import com.epam.code.mie.library.entities.Book;
import com.epam.code.mie.library.repositories.BooksRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BooksService {
private final BooksRepository booksRepository;

  public List<Book> getAllBooks() {
    return booksRepository.findAll();
  }
}
