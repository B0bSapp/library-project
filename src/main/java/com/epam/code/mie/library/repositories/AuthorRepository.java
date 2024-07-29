package com.epam.code.mie.library.repositories;

import com.epam.code.mie.library.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    boolean existsByNameAndLastNameAndSecondName(String name, String lastName, String secondName);
}
