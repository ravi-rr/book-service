package com.rr.bookservice.services;

import java.util.UUID;

public interface BookInventoryService {
    Integer getOnhandInventory(UUID uuid);
}
