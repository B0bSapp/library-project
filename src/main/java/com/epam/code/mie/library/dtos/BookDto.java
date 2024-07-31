package com.epam.code.mie.library.dtos;

import com.epam.code.mie.library.validation.AuthorExists;
import lombok.Data;

@Data
public class BookDto {
    private Long id;
    @AuthorExists
    private AuthorDto author;
    private String name;
    private String genre;
    private String description;
}