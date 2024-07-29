package com.epam.code.mie.library.services;

import com.epam.code.mie.library.entities.Book;
import com.epam.code.mie.library.repositories.BooksRepository;
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

    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Book> getBookByName(String name) {
        return booksRepository.findByName(name);
    }
}