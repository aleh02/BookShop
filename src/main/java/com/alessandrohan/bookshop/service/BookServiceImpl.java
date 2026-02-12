package com.alessandrohan.bookshop.service;

import com.alessandrohan.bookshop.domain.Book;
import com.alessandrohan.bookshop.mapper.BookMapper;
import com.alessandrohan.bookshop.repository.AuthorRepository;
import com.alessandrohan.bookshop.repository.BookRepository;
import com.alessandrohan.bookshop.repository.PublisherRepository;
import com.alessandrohan.bookshop.web.dto.request.BookCreateRequest;
import com.alessandrohan.bookshop.web.dto.request.BookQtyUpdateRequest;
import com.alessandrohan.bookshop.web.dto.response.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookServiceImpl(BookMapper bookMapper,
                           BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           PublisherRepository publisherRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::bookToBookResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse createNewBook(BookCreateRequest request) {
        return bookRepository.findByTitleAndPageNumAndAuthor_IdAndPublisher_Id(
                        request.getTitle(),
                        request.getPageNum(),
                        request.getAuthorId(),
                        request.getPublisherId())
                .map(bookMapper::bookToBookResponse)
                .orElseGet(() -> {
                    Book book = bookMapper.bookCreateReqToBook(request);
                    book.setAuthor(authorRepository.findById(request.getAuthorId())
                            .orElseThrow(ResourceNotFoundException::new));
                    book.setPublisher(publisherRepository.findById(request.getPublisherId())
                            .orElseThrow(ResourceNotFoundException::new));
                    Book savedBook = bookRepository.save(book);
                    return bookMapper.bookToBookResponse(savedBook);
                });
    }

    @Override
    public BookResponse updateBookQty(Long id, BookQtyUpdateRequest request) {
        return bookRepository.findById(id).map(book -> {
            book.setQty(request.getQty());
            return bookMapper.bookToBookResponse(book);
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException();
        }
        bookRepository.deleteById(id);
    }
}
