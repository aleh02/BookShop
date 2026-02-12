package com.alessandrohan.bookshop.mapper;

import com.alessandrohan.bookshop.domain.Book;
import com.alessandrohan.bookshop.web.dto.request.BookCreateRequest;
import com.alessandrohan.bookshop.web.dto.response.AuthorResponse;
import com.alessandrohan.bookshop.web.dto.response.BookResponse;
import com.alessandrohan.bookshop.web.dto.response.PublisherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "id", target = "id")
    BookResponse bookToBookResponse(Book book);

    Book bookCreateReqToBook(BookCreateRequest request);

    AuthorResponse authorToAuthorResponse(com.alessandrohan.bookshop.domain.Author author);

    PublisherResponse publisherToPublisherResponse(com.alessandrohan.bookshop.domain.Publisher publisher);
}
