package com.epam.code.mie.library.facades;

import com.epam.code.mie.library.dtos.BookDto;
import com.epam.code.mie.library.mappers.BooksMapper;
import com.epam.code.mie.library.services.BooksService;
import com.epam.code.mie.library.services.AuthorsService;
import com.epam.code.mie.library.entities.Book;
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
    private final AuthorsService authorsService;

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
        Book bookEntity = booksMapper.toEntity(bookDto);
        authorsService.findAuthorByNameAndLastNameAndSecondName(
                bookDto.getAuthorName(), 
                bookDto.getAuthorLastName(), 
                bookDto.getAuthorSecondName()
        ).ifPresent(bookEntity::setAuthor);
        return booksMapper.toDto(booksService.addBook(bookEntity));
    }
}