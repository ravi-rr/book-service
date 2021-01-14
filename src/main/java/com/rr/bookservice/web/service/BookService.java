package com.rr.bookservice.web.service;

import com.rr.bookservice.web.model.BookDto;

import java.util.UUID;

public interface BookService {
    BookDto getBookById(UUID bookId);

    BookDto saveNewBook(BookDto bookDto);

    void updateBook(UUID bookId, BookDto bookDto);

    void deleteById(UUID bookId);
}
