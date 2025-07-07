package com.example.restaurant.repository;

import com.example.restaurant.domain.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChequeRepository extends JpaRepository<Cheque, Long> {
    List<Cheque> findByBillStatus(Cheque.Status status);
    List<Cheque> findByBillStatusAndCustomer_CustomerId(Cheque.Status status, Long customerId);
    List<Cheque> findByBillStatusAndManagerBill_ManagerId(Cheque.Status status, Long managerId);
    Optional<Cheque> findByTransactionId(Long transId);
}
