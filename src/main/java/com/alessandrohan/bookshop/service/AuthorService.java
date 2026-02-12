package com.alessandrohan.bookshop.service;

import com.alessandrohan.bookshop.web.dto.request.AuthorCreateRequest;
import com.alessandrohan.bookshop.web.dto.response.AuthorResponse;

import java.util.List;

public interface AuthorService {
    List<AuthorResponse> getAllAuthors();

    AuthorResponse createNewAuthor(AuthorCreateRequest request);

    void deleteAuthor(Long id);
}
