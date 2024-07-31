package com.epam.code.mie.library.services;

import com.epam.code.mie.library.entities.Book;
import com.epam.code.mie.library.repositories.BooksRepository;
import com.epam.code.mie.library.repositories.AuthorsRepository;
import com.epam.code.mie.library.dtos.BookDto;
import com.epam.code.mie.library.mappers.BooksMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;
    private final AuthorsRepository authorsRepository;
    private final BooksMapper booksMapper;

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Book> getBookByName(String name) {
        return booksRepository.findByName(name);
    }

    public Book saveBook(BookDto bookDto) {
        Book book = booksMapper.toEntity(bookDto);
        return booksRepository.save(book);
    }
}