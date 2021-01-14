package com.rr.bookservice.web.service;

import com.rr.bookservice.web.model.BookDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public BookDto getBookById(UUID bookId) {
        return null;
    }

    @Override
    public BookDto saveNewBook(BookDto bookDto) {
        return null;
    }

    @Override
    public void updateBook(UUID bookId, BookDto bookDto) {

    }

    @Override
    public void deleteById(UUID bookId) {

    }
}
