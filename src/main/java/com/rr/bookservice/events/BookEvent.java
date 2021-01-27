package com.rr.bookservice.events;

import com.rr.bookservice.web.model.BookDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class BookEvent implements Serializable {

    static final long serialVersionUID = -8128836203454483154L;

    private final BookDto bookDto;
}
