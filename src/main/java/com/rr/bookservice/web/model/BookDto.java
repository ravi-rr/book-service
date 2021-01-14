package com.rr.bookservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private UUID id;
    private String bookName;
    private String genre;
    private Long isbn;
}
