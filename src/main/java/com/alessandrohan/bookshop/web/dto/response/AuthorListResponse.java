package com.alessandrohan.bookshop.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AuthorListResponse {
    private List<AuthorResponse> authors;
}
