package com.epam.code.mie.library.dtos;

import java.util.List;

public class AuthorDto {
    private final String name;
    private final String lastName;
    private final String secondName;
    private final List<BookDto> books;

    public AuthorDto(String name, String lastName, String secondName, List<BookDto> books) {
        this.name = name;
        this.lastName = lastName;
        this.secondName = secondName;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public List<BookDto> getBooks() {
        return books;
    }
}