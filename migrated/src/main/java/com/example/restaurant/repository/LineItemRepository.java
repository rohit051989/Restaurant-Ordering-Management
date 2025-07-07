package com.example.restaurant.repository;

import com.example.restaurant.domain.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineItemRepository extends JpaRepository<LineItem, Long> {
    List<LineItem> findByCustomer_CustomerIdAndStatus(Long customerId, LineItem.Status status);
    List<LineItem> findByTransId(Long transId);
}
