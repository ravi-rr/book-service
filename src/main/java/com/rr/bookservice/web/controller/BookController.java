package com.rr.bookservice.web.controller;

import com.rr.bookservice.web.model.BookDto;
import com.rr.bookservice.web.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
@RestController
public class BookController {

    private final BookService bookService;

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBook(@NotNull @PathVariable("bookId")UUID bookId) {
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody BookDto bookDto) {

        log.debug("in handle post..");
        val savedDto = bookService.saveNewBook(bookDto);

        val headers = new HttpHeaders();
        headers.add("Location", "api/v1/book/" + savedDto.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity handlePut(@PathVariable("bookId") UUID bookId, @Valid @RequestBody BookDto bookDto) {
        bookService.updateBook(bookId, bookDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT); // this is 204.. preferred response for PUT
    }

    /**
     * @ResponseStatus - alternative way of sending response status;
     * Could've used ResponseEntity as well; Makes sense when we have additional data to send in response.
     */
    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("bookId") UUID bookId) {
        bookService.deleteById(bookId);
    }
}
