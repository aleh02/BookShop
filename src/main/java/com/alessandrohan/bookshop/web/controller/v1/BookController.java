package com.alessandrohan.bookshop.web.controller.v1;

import com.alessandrohan.bookshop.service.BookService;
import com.alessandrohan.bookshop.web.dto.request.BookCreateRequest;
import com.alessandrohan.bookshop.web.dto.request.BookQtyUpdateRequest;
import com.alessandrohan.bookshop.web.dto.response.BookResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Books")
@RestController
@RequestMapping(BookController.BASE_URL)
public class BookController {
    public static final String BASE_URL = "api/v1/books";

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse createNewBook(@Valid @RequestBody BookCreateRequest request) {
        return bookService.createNewBook(request);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse updateBookQty(@PathVariable Long id, @Valid @RequestBody BookQtyUpdateRequest request) {
        return bookService.updateBookQty(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
