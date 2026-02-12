package com.alessandrohan.bookshop.mapper;

import com.alessandrohan.bookshop.domain.Publisher;
import com.alessandrohan.bookshop.web.dto.request.PublisherCreateRequest;
import com.alessandrohan.bookshop.web.dto.response.PublisherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    @Mapping(source = "id", target = "id")
    PublisherResponse publisherToPublisherResponse(Publisher publisher);

    Publisher publisherCreateReqToPublisher(PublisherCreateRequest request);
}
