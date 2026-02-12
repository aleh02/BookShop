package com.alessandrohan.bookshop.service;

import com.alessandrohan.bookshop.domain.Author;
import com.alessandrohan.bookshop.mapper.AuthorMapper;
import com.alessandrohan.bookshop.repository.AuthorRepository;
import com.alessandrohan.bookshop.web.dto.request.AuthorCreateRequest;
import com.alessandrohan.bookshop.web.dto.response.AuthorResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorMapper authorMapper;
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorMapper authorMapper, AuthorRepository authorRepository) {
        this.authorMapper = authorMapper;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::authorToAuthorResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponse createNewAuthor(AuthorCreateRequest request) {
        return authorRepository.findByFirstNameAndLastNameAndBirthDate(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getBirthDate())
                .map(authorMapper::authorToAuthorResponse)
                .orElseGet(() -> {
                    Author author = authorMapper.authorCreateReqtoAuthor(request);
                    Author savedAuthor = authorRepository.save(author);
                    return authorMapper.authorToAuthorResponse(savedAuthor);
                });
    }

    @Override
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException();
        }
        authorRepository.deleteById(id);
    }
}
