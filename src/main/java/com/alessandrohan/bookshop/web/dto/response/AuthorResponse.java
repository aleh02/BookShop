package com.alessandrohan.bookshop.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AuthorResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;
}
