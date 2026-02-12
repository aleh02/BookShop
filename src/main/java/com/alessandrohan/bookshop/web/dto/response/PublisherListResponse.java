package com.alessandrohan.bookshop.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PublisherListResponse {
    private List<PublisherResponse> publishers;
}
