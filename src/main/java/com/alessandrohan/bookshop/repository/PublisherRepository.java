package com.alessandrohan.bookshop.repository;

import com.alessandrohan.bookshop.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findByNameAndAddress(String name, String address);
}
