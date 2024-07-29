package com.epam.code.mie.library.services;

import com.epam.code.mie.library.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    public boolean authorExists(String name, String lastName, String secondName) {
        return authorRepository.existsByNameAndLastNameAndSecondName(name, lastName, secondName);
    }
}
