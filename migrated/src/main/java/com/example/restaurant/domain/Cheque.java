package com.example.restaurant.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "cheque")
public class Cheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    private Double billAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) default 'ACTIVE'")
    private Status billStatus;

    @Column(unique = true)
    private Long transactionId;

    public enum Status {
        ACTIVE,
        INACTIVE
    }

    @Past
    @Temporal(TemporalType.DATE)
    private Date billGeneratedDate;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Manager managerBill;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    // getters and setters
    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Status getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Status billStatus) {
        this.billStatus = billStatus;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getBillGeneratedDate() {
        return billGeneratedDate;
    }

    public void setBillGeneratedDate(Date billGeneratedDate) {
        this.billGeneratedDate = billGeneratedDate;
    }

    public Manager getManagerBill() {
        return managerBill;
    }

    public void setManagerBill(Manager managerBill) {
        this.managerBill = managerBill;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
