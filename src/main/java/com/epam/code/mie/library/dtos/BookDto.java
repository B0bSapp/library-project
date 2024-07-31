package com.epam.code.mie.library.dtos;

import com.epam.code.mie.library.annotations.AuthorExists;

public record BookDto(
    Long id,
    @AuthorExists AuthorDto author,
    String name,
    String genre,
    String description
) {}