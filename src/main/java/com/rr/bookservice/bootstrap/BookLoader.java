package com.rr.bookservice.bootstrap;

import com.rr.bookservice.domain.Book;
import com.rr.bookservice.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookLoader implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BookLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBookObjects();
    }

    private void loadBookObjects() {
        if(bookRepository.count() == 0) {

            bookRepository.save(Book.builder()
                .bookName("Atlas Shrugged")
                .version(1L)
                .genre("Fiction")
                .build());

            bookRepository.save(Book.builder()
                    .bookName("Fountainhead")
                    .version(2L)
                    .genre("Fiction")
                    .build());
        }
    }
}
