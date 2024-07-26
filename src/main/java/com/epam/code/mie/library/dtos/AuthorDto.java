package com.epam.code.mie.library.dtos;

import java.util.List;

public record AuthorDto(String name, String lastName, String secondName, List<BookDto> books) {

}
