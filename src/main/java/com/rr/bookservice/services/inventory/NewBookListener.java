package com.rr.bookservice.services.inventory;

import com.rr.bookservice.config.JmsConfig;
import com.rr.bookservice.domain.Book;
import com.rr.bookservice.events.NewBookEvent;
import com.rr.bookservice.events.NewInventoryEvent;
import com.rr.bookservice.repositories.BookRepository;
import com.rr.bookservice.web.model.BookDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewBookListener {

    private final BookRepository bookRepository;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.BOOK_REQUEST_QUEUE)
    public void listen(NewBookEvent event) {
        BookDto bookDto = event.getBookDto();

        Book book = bookRepository.getOne(bookDto.getId());

        bookDto.setQuantityOnHand(book.getDesiredQuantity());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(bookDto);

        log.debug("New Book: {}, QOH: {}", book.getMinOnHand(), bookDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
