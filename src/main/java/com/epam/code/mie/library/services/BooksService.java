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
    private final BooksMapper booksMapper;

    public List<BookDto> getAllBooks() {
        return booksMapper.toBookDtoList(booksRepository.findAll());
    }

    public Optional<BookDto> getBookByName(String name) {
        return booksRepository.findByName(name).map(booksMapper::toBookDto);
    }
}