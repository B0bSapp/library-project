package com.epam.code.mie.library.facades;

import com.epam.code.mie.library.dtos.BookDto;
import com.epam.code.mie.library.mappers.BooksMapper;
import com.epam.code.mie.library.services.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksFacade {

    private final BooksService booksService;
    private final BooksMapper booksMapper;

    @Transactional(readOnly = true)
    public List<BookDto> getAllBooks() {
        return booksMapper.toDtoList(booksService.getAllBooks());
    }

    @Transactional(readOnly = true)
    public Optional<BookDto> getBookByName(String name) {
        return booksService.getBookByName(name).map(booksMapper::toDto);
    }

    @Transactional
    public BookDto addBook(BookDto bookDto) {
        return booksMapper.toDto(booksService.addBook(booksMapper.toEntity(bookDto)));
    }
    
    @Transactional
    public BookDto addNewBook(BookDto bookDto) {
        return booksMapper.toDto(booksService.addBook(booksMapper.toEntity(bookDto)));
    }
}