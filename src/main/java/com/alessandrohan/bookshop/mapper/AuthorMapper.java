package com.alessandrohan.bookshop.mapper;

import com.alessandrohan.bookshop.domain.Author;
import com.alessandrohan.bookshop.web.dto.request.AuthorCreateRequest;
import com.alessandrohan.bookshop.web.dto.response.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(source = "id", target = "id")
    AuthorResponse authorToAuthorResponse(Author author);

    Author authorCreateReqtoAuthor(AuthorCreateRequest request);
}
