package com.rr.bookservice.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDtoV2 {
    private UUID id;
    private String bookName;
    private String genre;
    private String isbn;
}
