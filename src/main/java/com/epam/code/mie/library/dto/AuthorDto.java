package com.epam.code.mie.library.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AuthorDto {
    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Last name is mandatory")
    @Size(max = 100, message = "Last name cannot exceed 100 characters")
    private String lastName;

    @Size(max = 100, message = "Second name cannot exceed 100 characters")
    private String secondName;
}