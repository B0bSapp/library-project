package com.epam.code.mie.library.facades;

import com.epam.code.mie.library.dtos.BookDto;
import com.epam.code.mie.library.dtos.AuthorDto;
import com.epam.code.mie.library.mappers.BooksMapper;
import com.epam.code.mie.library.mappers.AuthorsMapper;
import com.epam.code.mie.library.services.BooksService;
import com.epam.code.mie.library.services.AuthorsService;
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
    private final AuthorsMapper authorsMapper;

    @Transactional(readOnly = true)
    public List<BookDto> getAllBooks() {
        return booksMapper.toDtoList(booksService.getAllBooks());
    }

    @Transactional(readOnly = true)
    public Optional<BookDto> getBookByName(String name) {
        return booksService.getBookByName(name).map(booksMapper::toDto);
    }

    @Transactional
    public BookDto saveBookWithAuthor(BookDto bookDto, String authorName, String authorLastName, String authorSecondName) {
        Optional<AuthorDto> optionalAuthorDto = authorsService.getAuthorByNameAndLastNameAndSecondName(authorName, authorLastName, authorSecondName)
                                                               .map(authorsMapper::toDto);
        if (optionalAuthorDto.isPresent()) {
            bookDto.setAuthor(optionalAuthorDto.get());
            return booksMapper.toDto(booksService.saveBook(booksMapper.toEntity(bookDto)));
        } else {
            throw new IllegalArgumentException("Author not found");
        }
    }
}