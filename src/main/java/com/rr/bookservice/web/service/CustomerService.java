package com.rr.bookservice.web.service;

import com.rr.bookservice.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
