package com.epam.code.mie.library.validation;

import com.epam.code.mie.library.dtos.AuthorDto;
import com.epam.code.mie.library.repositories.AuthorsRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class AuthorExistsValidator implements ConstraintValidator<AuthorExists, AuthorDto> {

    private final AuthorsRepository authorsRepository;

    @Override
    public boolean isValid(AuthorDto authorDto, ConstraintValidatorContext context) {
        if (authorDto == null) {
            return false;
        }
        return authorsRepository.findByNameAndLastNameAndSecondName(
                authorDto.name(), authorDto.lastName(), authorDto.secondName()).isPresent();
    }
}
