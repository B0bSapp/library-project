package com.epam.code.mie.library.repositories;

import com.epam.code.mie.library.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameAndLastNameAndSecondName(String name, String lastName, String secondName);
}
