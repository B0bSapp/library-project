package com.epam.code.mie.library.dtos;

import com.epam.code.mie.library.validation.AuthorExists;
import java.util.List;

public record BookDto(
    Long id,
    @AuthorExists AuthorDto author,
    String name,
    String genre,
    String description
) {}