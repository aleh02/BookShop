package com.alessandrohan.bookshop.web.dto.response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublisherResponse {

    private Long id;

    private String name;

    private String address;
}
