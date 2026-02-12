package com.alessandrohan.bookshop.web.controller.v1;

import com.alessandrohan.bookshop.service.PublisherService;
import com.alessandrohan.bookshop.web.dto.request.PublisherAddressUpdateRequest;
import com.alessandrohan.bookshop.web.dto.request.PublisherCreateRequest;
import com.alessandrohan.bookshop.web.dto.response.PublisherResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Publishers")
@RestController
@RequestMapping(PublisherController.BASE_URL)
public class PublisherController {
    public static final String BASE_URL = "api/v1/publishers";

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PublisherResponse> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublisherResponse createNewPublisher(@Valid @RequestBody PublisherCreateRequest request) {
        return publisherService.createNewPublisher(request);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublisherResponse updatePublisherAddress(@PathVariable Long id, @Valid @RequestBody PublisherAddressUpdateRequest request) {
        return publisherService.updatePublisherAddress(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
    }
}
