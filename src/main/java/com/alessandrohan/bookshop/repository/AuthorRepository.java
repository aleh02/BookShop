package com.alessandrohan.bookshop.repository;

import com.alessandrohan.bookshop.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByFirstNameAndLastNameAndBirthDate(String firstName, String lastName, LocalDate birthDate);
}
