package com.epam.code.mie.library.controllers;

import com.epam.code.mie.library.dtos.BookDto;
import com.epam.code.mie.library.facades.BooksFacade;
import com.epam.code.mie.library.services.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Library Management System", description = "Operations related to library management")
public class LibraryController {

  private final BooksFacade booksFacade;
  private final AuthorService authorService;

  @Operation(summary = "Get list of all books")
  @GetMapping("/books")
  public List<BookDto> getAllBooks(){
    return booksFacade.getAllBooks();
  }

  @Operation(summary = "Get a book by name")
  @GetMapping("/books/name")
  public ResponseEntity<BookDto> getBookByName(@RequestParam String name) {
    return booksFacade.getBookByName(name)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @Operation(summary = "Add a new book")
  @PostMapping("/books")
  public ResponseEntity<?> addBook(@RequestBody BookDto bookDto) {
    boolean authorExists = authorService.authorExists(
        bookDto.getAuthor().getName(),
        bookDto.getAuthor().getLastName(),
        bookDto.getAuthor().getSecondName()
    );

    if (!authorExists) {
        return ResponseEntity.badRequest().body("Author does not exist");
    }

    BookDto createdBook = booksFacade.addBook(bookDto);
    return ResponseEntity.ok(createdBook);
  }
}