package com.alessandrohan.bookshop.web.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  //deserializable
@AllArgsConstructor
public class BookCreateRequest {

    @NotBlank
    private String title;

    @NotNull
    @Positive
    private Integer price;

    @NotNull
    @Positive
    private Integer pageNum;

    @NotNull
    @Min(0)
    private Integer qty;

    @NotNull
    @Positive
    private Long authorId;

    @NotNull
    @Positive
    private Long publisherId;
}
