package com.epam.code.mie.library.dtos;

public record BookDto(
    Long id,
    AuthorDto author,
    String name,
    String genre,
    String description
) {}