package com.alessandrohan.bookshop.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookResponse {

    private Long id;

    private String title;

    private Integer price;

    private Integer pageNum;

    private Integer qty;

    private AuthorResponse author;

    private PublisherResponse publisher;
}
