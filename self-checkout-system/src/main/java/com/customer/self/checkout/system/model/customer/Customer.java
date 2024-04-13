package com.customer.self.checkout.system.model.customer;

public class Customer {
    private String id;
    private String customerName;
    private String address;
    private String contactNumber;

    public Customer(String id, String customerName, String address, String contactNumber) {
        this.id = id;
        this.customerName = customerName;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
