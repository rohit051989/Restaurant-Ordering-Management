package com.example.restaurant.service;

import com.example.restaurant.domain.LineItem;
import com.example.restaurant.repository.LineItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineItemService extends BaseService<LineItem, Long> {

    private final LineItemRepository repository;

    public LineItemService(LineItemRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<LineItem> findByCustomerAndStatus(Long customerId, LineItem.Status status) {
        return repository.findByCustomer_CustomerIdAndStatus(customerId, status);
    }

    public List<LineItem> findByTransId(Long transId) {
        return repository.findByTransId(transId);
    }
}
