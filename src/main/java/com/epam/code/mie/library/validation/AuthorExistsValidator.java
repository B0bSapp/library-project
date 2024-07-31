package com.epam.code.mie.library.validation;

import com.epam.code.mie.library.services.AuthorService;
import com.epam.code.mie.library.dtos.AuthorDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorExistsValidator implements ConstraintValidator<AuthorExists, AuthorDto> {

    @Autowired
    private AuthorService authorService;

    @Override
    public boolean isValid(AuthorDto authorDto, ConstraintValidatorContext context) {
        return authorService.authorExists(
            authorDto.getName(),
            authorDto.getLastName(),
            authorDto.getSecondName()
        );
    }
}