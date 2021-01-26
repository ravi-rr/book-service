package com.rr.bookservice.events;

import com.rr.bookservice.web.model.BookDto;

public class NewInventoryEvent extends BookEvent {
    public NewInventoryEvent(BookDto bookDto) {
        super(bookDto);
    }
}
