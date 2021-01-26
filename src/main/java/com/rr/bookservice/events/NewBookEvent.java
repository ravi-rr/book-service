package com.rr.bookservice.events;

import com.rr.bookservice.web.model.BookDto;

public class NewBookEvent extends BookEvent {

    public NewBookEvent(BookDto bookDto) {
        super(bookDto);
    }
}
