package com.rr.bookservice.web.controller;

import com.rr.bookservice.web.model.BookDto;
import com.rr.bookservice.web.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/book")
@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable("bookId")UUID bookId) {
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BookDto bookDto) {
        BookDto savedDto = bookService.saveNewBook(bookDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/book/" + savedDto.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity handlePut(@PathVariable("bookId") UUID bookId, @Valid @RequestBody BookDto bookDto) {
        bookService.updateBook(bookId, bookDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT); // this is 204.. preferred response for PUT
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("bookId") UUID bookId) {
        bookService.deleteById(bookId);
    }

    /**
     * @ResponseStatus - alternative way of sending response status;
     * Could've used ResponseEntity as well; Makes sense when we have additional data to send in response.
     */

}
