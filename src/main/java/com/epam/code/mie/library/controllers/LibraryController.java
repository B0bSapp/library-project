package com.epam.code.mie.library.controllers;

import com.epam.code.mie.library.dtos.BookDto;
import com.epam.code.mie.library.facades.BooksFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = "Library Controller", description = "Controller for library endpoints")
public class LibraryController {

  private final BooksFacade booksFacade;

  @GetMapping("/books")
  @ApiOperation(value = "Get all books", notes = "Fetches all books available in the library")
  public List<BookDto> getAllBooks(){
    return booksFacade.getAllBooks();
  }
}