package com.example.restaurant.service;

import com.example.restaurant.domain.Cheque;
import com.example.restaurant.repository.ChequeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChequeService extends BaseService<Cheque, Long> {

    private final ChequeRepository repository;

    public ChequeService(ChequeRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Cheque> findByStatus(Cheque.Status status) {
        return repository.findByBillStatus(status);
    }

    public List<Cheque> findByStatusAndCustomerId(Cheque.Status status, Long customerId) {
        return repository.findByBillStatusAndCustomer_CustomerId(status, customerId);
    }

    public List<Cheque> findByStatusAndManagerId(Cheque.Status status, Long managerId) {
        return repository.findByBillStatusAndManagerBill_ManagerId(status, managerId);
    }

    public Optional<Cheque> findByTransactionId(Long transId) {
        return repository.findByTransactionId(transId);
    }
}
