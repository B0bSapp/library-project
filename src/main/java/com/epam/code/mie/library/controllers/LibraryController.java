package com.epam.code.mie.library.controllers;

import com.epam.code.mie.library.dtos.BookDto;
import com.epam.code.mie.library.facades.BooksFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Library Management System", description = "Operations related to library management")
public class LibraryController {

  private final BooksFacade booksFacade;

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
}