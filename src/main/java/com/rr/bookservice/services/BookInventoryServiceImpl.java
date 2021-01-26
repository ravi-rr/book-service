package com.rr.bookservice.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookInventoryServiceImpl implements BookInventoryService {
    @Override
    public Integer getOnhandInventory(UUID uuid) {
        return 1;
    }
}
