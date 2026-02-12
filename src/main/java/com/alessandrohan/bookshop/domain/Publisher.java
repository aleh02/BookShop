package com.alessandrohan.bookshop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "publishers", uniqueConstraints = {
        @UniqueConstraint(name = "uk_publisher_name_address", columnNames = {"name", "address"})
})
public class Publisher extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "address", nullable = false)
    @NotBlank
    private String address;
}
