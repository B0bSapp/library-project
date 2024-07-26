package com.epam.code.mie.library.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

public record BookDto(
    @Schema(description = "Name of the book") String name, 
    @Schema(description = "Author of the book") AuthorDto author, 
    @Schema(description = "Genre of the book") String genre, 
    @Schema(description = "Description of the book") String description
) {

}