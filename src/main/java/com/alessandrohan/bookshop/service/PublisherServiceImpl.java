package com.alessandrohan.bookshop.service;

import com.alessandrohan.bookshop.domain.Publisher;
import com.alessandrohan.bookshop.mapper.PublisherMapper;
import com.alessandrohan.bookshop.repository.PublisherRepository;
import com.alessandrohan.bookshop.web.dto.request.PublisherAddressUpdateRequest;
import com.alessandrohan.bookshop.web.dto.request.PublisherCreateRequest;
import com.alessandrohan.bookshop.web.dto.response.PublisherResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherMapper publisherMapper;
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherMapper publisherMapper, PublisherRepository publisherRepository) {
        this.publisherMapper = publisherMapper;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<PublisherResponse> getAllPublishers() {
        return publisherRepository.findAll()
                .stream()
                .map(publisherMapper::publisherToPublisherResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PublisherResponse createNewPublisher(PublisherCreateRequest request) {
        return publisherRepository.findByNameAndAddress(request.getName(), request.getAddress())
                .map(publisherMapper::publisherToPublisherResponse)
                .orElseGet(() -> {
                    Publisher publisher = publisherMapper.publisherCreateReqToPublisher(request);
                    Publisher savedPublisher = publisherRepository.save(publisher);
                    return publisherMapper.publisherToPublisherResponse(savedPublisher);
                });
    }

    @Override
    public PublisherResponse updatePublisherAddress(Long id, PublisherAddressUpdateRequest request) {
        return publisherRepository.findById(id).map(publisher -> {
            publisher.setAddress(request.getAddress());
            return publisherMapper.publisherToPublisherResponse(publisher);
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deletePublisher(Long id) {
        if (!publisherRepository.existsById(id)) {
            throw new ResourceNotFoundException();
        }
        publisherRepository.deleteById(id);
    }
}
