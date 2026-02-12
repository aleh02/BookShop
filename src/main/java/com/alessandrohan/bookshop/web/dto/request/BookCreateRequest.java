package com.alessandrohan.bookshop.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @NotNull
    @Positive
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer price;

    @NotNull
    @Positive
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer pageNum;

    @NotNull
    @Min(0)
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer qty;

    @NotNull
    @Positive
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Long authorId;

    @NotNull
    @Positive
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Long publisherId;
}
