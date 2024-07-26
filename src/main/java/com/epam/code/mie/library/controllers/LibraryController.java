package com.epam.code.mie.library.controllers;

import com.epam.code.mie.library.dtos.BookDto;
import com.epam.code.mie.library.facades.BooksFacade;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LibraryController {

  private final BooksFacade booksFacade;

  @GetMapping("/books")
  public List<BookDto> getAllBooks(){
    return booksFacade.getAllBooks();
  }
}
