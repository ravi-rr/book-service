package com.rr.bookservice.web.mappers;

import com.rr.bookservice.domain.Book;
import com.rr.bookservice.web.model.BookDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BookMapper {

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);
}
