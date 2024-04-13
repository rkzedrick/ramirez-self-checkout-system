package com.customer.self.checkout.system.data.utils;

public final class QueryConstants {
    private QueryConstants() {
    }

    //Customer DAO constants
    public static final String GET_ALL_CUSTOMERS_STATEMENT = "SELECT * FROM CUSTOMER";
    public static final String GET_CUSTOMER_BY_ID_STATEMENT = "SELECT * FROM CUSTOMER WHERE ID = ?";
    public static final String ADD_CUSTOMER_STATEMENT = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_STATEMENT = "UPDATE CUSTOMER " +
            "SET customer_name = ?, address = ?, contact_number = ? " +
            "WHERE id = ?";
    //Item DAO constants
    public static final String GET_ALL_ITEMS_STATEMENT = "SELECT * FROM ITEM";
    public static final String GET_ITEM_BY_ID_STATEMENT = "SELECT * FROM ITEM WHERE id = ?";
    public static final String ADD_ITEM_STATEMENT = "INSERT INTO ITEM VALUES (?, ?, ?, ?)";
    public static final String GET_ITEMS_BY_IDS_STATEMENT = "SELECT * FROM item " +
            "WHERE id IN";

    //Transaction DAO constants
    public static final String GET_TRANSACTION_ITEMS_COUNT = "SELECT * FROM TABLE(GET_ITEM_COUNT())";
}
