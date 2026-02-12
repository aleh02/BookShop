package com.alessandrohan.bookshop.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "books", uniqueConstraints = {
        @UniqueConstraint(name = "uk_book_identity", columnNames = {"title", "page_num", "author_id", "publisher_id"})
})
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Book extends BaseEntity {

    @Column(name = "title", nullable = false)
    @NotEmpty
    private String title;

    @Column(name = "price", nullable = false)
    @Positive
    @NotNull
    private Integer price;

    @Column(name = "page_num", nullable = false)
    @Positive
    @NotNull
    private Integer pageNum;

    @Column(name = "qty", nullable = false)
    @Min(0)
    private Integer qty;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

}
