package com.epam.code.mie.library.controllers;

import com.epam.code.mie.library.dto.BookDto;
import com.epam.code.mie.library.services.BooksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Library Management System", description = "Operations related to library management")
public class LibraryController {

    private final BooksService booksService;

    public LibraryController(BooksService booksService) {
        this.booksService = booksService;
    }

    @Operation(summary = "Get list of all books")
    @GetMapping("/books")
    public List<BookDto> getAllBooks(){
        return booksService.getAllBooks();
    }

    @Operation(summary = "Get a book by name")
    @GetMapping("/books/name")
    public ResponseEntity<BookDto> getBookByName(@RequestParam String name) {
        return booksService.getBookByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Add a new book")
    @PostMapping("/books")
    public ResponseEntity<BookDto> addBook(@RequestBody @Valid BookDto bookDto) {
        BookDto createdBook = booksService.addBook(bookDto);
        return ResponseEntity.ok(createdBook);
    }
}