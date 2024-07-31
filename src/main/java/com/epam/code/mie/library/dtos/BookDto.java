package com.epam.code.mie.library.dtos;

public class BookDto {
    private Long id;
    private AuthorDto author;
    private String name;
    private String genre;
    private String description;

    public BookDto(Long id, AuthorDto author, String name, String genre, String description) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.genre = genre;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}