package com.epam.code.mie.library.facades;

import com.epam.code.mie.library.dtos.BookDto;
import com.epam.code.mie.library.dtos.AuthorDto;
import com.epam.code.mie.library.services.BooksService;
import com.epam.code.mie.library.services.AuthorsService;
import com.epam.code.mie.library.mappers.BooksMapper;
import com.epam.code.mie.library.mappers.AuthorsMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BooksFacadeTest {

    @Mock
    private BooksService booksService;

    @Mock
    private BooksMapper booksMapper;

    @Mock
    private AuthorsService authorsService;

    @Mock
    private AuthorsMapper authorsMapper;

    @InjectMocks
    private BooksFacade booksFacade;

    private BookDto bookDto;
    private AuthorDto authorDto;

    @BeforeEach
    void setUp() {
        authorDto = new AuthorDto();
        authorDto.setName("AuthorName");
        authorDto.setLastName("AuthorLastName");
        authorDto.setSecondName("AuthorSecondName");

        bookDto = new BookDto();
        bookDto.setName("Test Book");
        bookDto.setGenre("Genre");
        bookDto.setDescription("Description");
        bookDto.setAuthor(authorDto);
    }

    @Test
    void testGetAllBooks() {
        when(booksService.getAllBooks()).thenReturn(Collections.emptyList());
        when(booksMapper.toDtoList(any())).thenReturn(Collections.emptyList());

        List<BookDto> allBooks = booksFacade.getAllBooks();

        assertNotNull(allBooks);
        assertTrue(allBooks.isEmpty());
    }

    @Test
    void testGetBookByName() {
        when(booksService.getBookByName(anyString())).thenReturn(Optional.of(new com.epam.code.mie.library.entities.Book()));
        when(booksMapper.toDto(any())).thenReturn(bookDto);

        Optional<BookDto> foundBook = booksFacade.getBookByName("Test Book");

        assertTrue(foundBook.isPresent());
        assertEquals("Test Book", foundBook.get().getName());
    }

    @Test
    void testSaveBookWithAuthor() {
        when(authorsService.getAuthorByNameAndLastNameAndSecondName(anyString(), anyString(), anyString()))
                .thenReturn(Optional.of(new com.epam.code.mie.library.entities.Author()));
        when(authorsMapper.toDto(any())).thenReturn(authorDto);
        when(booksMapper.toEntity(any())).thenReturn(new com.epam.code.mie.library.entities.Book());
        when(booksService.saveBook(any())).thenReturn(new com.epam.code.mie.library.entities.Book());
        when(booksMapper.toDto(any())).thenReturn(bookDto);

        BookDto savedBook = booksFacade.saveBookWithAuthor(bookDto, "AuthorName", "AuthorLastName", "AuthorSecondName");

        assertNotNull(savedBook);
        assertEquals("Test Book", savedBook.getName());
    }

    @Test
    void testSaveBookWithAuthor_AuthorNotFound() {
        when(authorsService.getAuthorByNameAndLastNameAndSecondName(anyString(), anyString(), anyString()))
                .thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> booksFacade.saveBookWithAuthor(bookDto, "AuthorName", "AuthorLastName", "AuthorSecondName"));

        assertEquals("Author not found", exception.getMessage());
    }
}