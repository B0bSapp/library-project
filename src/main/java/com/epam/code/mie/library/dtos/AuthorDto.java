package com.epam.code.mie.library.dtos;

import lombok.Data;
import java.util.List;

@Data
public class AuthorDto {
    private String name;
    private String lastName;
    private String secondName;
    private List<BookDto> books;
}