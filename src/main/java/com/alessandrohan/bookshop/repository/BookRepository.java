package com.alessandrohan.bookshop.repository;

import com.alessandrohan.bookshop.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitleAndPageNumAndAuthor_IdAndPublisher_Id(String title, Integer pageNum, Long authorId, Long publisherId);
}
