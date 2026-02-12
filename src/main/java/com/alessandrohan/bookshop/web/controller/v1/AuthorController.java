package com.alessandrohan.bookshop.web.controller.v1;

import com.alessandrohan.bookshop.service.AuthorService;
import com.alessandrohan.bookshop.web.dto.request.AuthorCreateRequest;
import com.alessandrohan.bookshop.web.dto.response.AuthorResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Authors")
@RestController
@RequestMapping(AuthorController.BASE_URL)
public class AuthorController {
    public static final String BASE_URL = "api/v1/authors";

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<AuthorResponse> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponse createNewAuthor(@Valid @RequestBody AuthorCreateRequest request) {
        return authorService.createNewAuthor(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
