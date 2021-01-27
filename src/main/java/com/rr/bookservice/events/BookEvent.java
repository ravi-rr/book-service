package com.rr.bookservice.events;

import com.rr.bookservice.web.model.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEvent implements Serializable {

    static final long serialVersionUID = -8128836203454483154L;

    private BookDto bookDto;
}
