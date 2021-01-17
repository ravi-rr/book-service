package com.rr.bookservice.web.service.v2;

import com.rr.bookservice.web.model.v2.BookDtoV2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookServiceImplV2 implements BookServiceV2 {
    @Override
    public BookDtoV2 getBookById(UUID bookId) {
        return null;
    }
}
