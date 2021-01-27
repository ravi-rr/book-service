package com.rr.bookservice.events;

import com.rr.bookservice.web.model.BookDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BookEvent {
    public NewInventoryEvent(BookDto bookDto) {
        super(bookDto);
    }
}
