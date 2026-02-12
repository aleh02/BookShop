package com.alessandrohan.bookshop.service;

import com.alessandrohan.bookshop.web.dto.request.PublisherAddressUpdateRequest;
import com.alessandrohan.bookshop.web.dto.request.PublisherCreateRequest;
import com.alessandrohan.bookshop.web.dto.response.PublisherResponse;

import java.util.List;

public interface PublisherService {

    List<PublisherResponse> getAllPublishers();

    PublisherResponse createNewPublisher(PublisherCreateRequest request);

    PublisherResponse updatePublisherAddress(Long id, PublisherAddressUpdateRequest request);

    void deletePublisher(Long id);
}
