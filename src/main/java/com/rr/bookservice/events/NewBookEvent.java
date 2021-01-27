package com.rr.bookservice.events;

import com.rr.bookservice.web.model.BookDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewBookEvent extends BookEvent {

    public NewBookEvent(BookDto bookDto) {
        super(bookDto);
    }
}
