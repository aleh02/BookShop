package com.alessandrohan.bookshop.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCreateRequest {
    @NotBlank
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private String firstName;

    @NotBlank
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastName;

    @NotNull
    @Past
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate birthDate;
}
