package com.alessandrohan.bookshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "authors", uniqueConstraints = {
        @UniqueConstraint(name = "uk_author_full_identity", columnNames = {"first_name", "last_name", "birth_date"})
})
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
public class Author extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    @NotNull
    @Past
    private LocalDate birthDate;
}
