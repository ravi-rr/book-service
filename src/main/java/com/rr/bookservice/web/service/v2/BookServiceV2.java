package com.rr.bookservice.web.service.v2;

import com.rr.bookservice.web.model.BookDto;
import com.rr.bookservice.web.model.v2.BookDtoV2;

import java.util.UUID;

public interface BookServiceV2 {
    BookDtoV2 getBookById(UUID bookId);
}
