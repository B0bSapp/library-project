package com.epam.code.mie.library.validation;

import com.epam.code.mie.library.services.AuthorService;
import com.epam.code.mie.library.dto.AuthorDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorExistsValidator implements ConstraintValidator<AuthorExists, AuthorDto> {

    @Autowired
    private AuthorService authorService;

    @Override
    public void initialize(AuthorExists constraintAnnotation) {
        // Initialization code if needed
    }

    @Override
    public boolean isValid(AuthorDto authorDto, ConstraintValidatorContext context) {
        if (authorDto == null) {
            return true; // consider null as valid, handle null-check in service if necessary
        }

        boolean exists = authorService.authorExists(
            authorDto.getName(),
            authorDto.getLastName(),
            authorDto.getSecondName()
        );

        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Author does not exist")
                   .addPropertyNode("author")
                   .addConstraintViolation();
        }

        return exists;
    }
}