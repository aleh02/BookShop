package com.alessandrohan.bookshop.service;

import com.alessandrohan.bookshop.web.dto.request.BookCreateRequest;
import com.alessandrohan.bookshop.web.dto.request.BookQtyUpdateRequest;
import com.alessandrohan.bookshop.web.dto.response.BookResponse;

import java.util.List;

public interface BookService {

    List<BookResponse> getAllBooks();

    BookResponse createNewBook(BookCreateRequest request);

    BookResponse updateBookQty(Long id, BookQtyUpdateRequest request);

    void deleteBook(Long id);
}
