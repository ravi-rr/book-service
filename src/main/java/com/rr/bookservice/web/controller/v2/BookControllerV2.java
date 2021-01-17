package com.rr.bookservice.web.controller.v2;

import com.rr.bookservice.web.model.BookDto;
import com.rr.bookservice.web.model.v2.BookDtoV2;
import com.rr.bookservice.web.service.BookService;
import com.rr.bookservice.web.service.v2.BookServiceV2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v2/book")
@RestController
public class BookControllerV2 {

    private final BookServiceV2 bookService;

    public BookControllerV2(BookServiceV2 bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDtoV2> getBook(@PathVariable("bookId") UUID bookId) {
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
    }
}
