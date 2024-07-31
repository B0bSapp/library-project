package com.epam.code.mie.library.repositories;

import com.epam.code.mie.library.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Long> {
}
