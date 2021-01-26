package com.rr.bookservice.services;

import com.rr.bookservice.config.JmsConfig;
import com.rr.bookservice.domain.Book;
import com.rr.bookservice.events.BookEvent;
import com.rr.bookservice.repositories.BookRepository;
import com.rr.bookservice.web.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewBookService {
    private final BookRepository bookRepository;
    private final BookInventoryService bookInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BookMapper bookMapper;

    @Scheduled(fixedRate = 5000) //every 5 seconds
    public void checkForLowInventory() {
        List<Book> books = bookRepository.findAll();

        books.forEach(book -> {
            Integer invQOH = bookInventoryService.getOnhandInventory(book.getId());

            log.debug("Min Onhand is : {}", book.getMinOnHand());
            log.debug("Inventory is: {}", invQOH);

            if(book.getMinOnHand() >= invQOH) {
                jmsTemplate.convertAndSend(JmsConfig.BOOK_REQUEST_QUEUE, new BookEvent(bookMapper.bookToBookDto(book)));
            }
        });
    }
}
