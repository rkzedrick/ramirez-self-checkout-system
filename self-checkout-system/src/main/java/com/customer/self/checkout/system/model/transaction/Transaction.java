package com.customer.self.checkout.system.model.transaction;

import java.security.Timestamp;

public class Transaction {
    private long id;
    private String customerId;
    private String itemId;
    private int transactionNumber;
    private Timestamp transactionDate;


    public Transaction() {
    }

    public Transaction(String customerId, String itemId, int transactionNumber, Timestamp transactionDate) {
        this.customerId = customerId;
        this.itemId = itemId;
        this.transactionNumber = transactionNumber;
        this.transactionDate = transactionDate;

    }

    public Transaction(long id, String customerId, String itemId, int transactionNumber, Timestamp transactionDate) {
        this.id = id;
        this.customerId = customerId;
        this.itemId = itemId;
        this.transactionNumber = transactionNumber;
        this.transactionDate = transactionDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

}
