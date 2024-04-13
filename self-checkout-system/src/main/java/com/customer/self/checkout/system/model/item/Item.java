package com.customer.self.checkout.system.model.item;



public class Item {
    /** A unique id of the item. */
    private String id;
    /** The description of material/item. */
    private String description;
    /** The price of the item. */
    private int price;
    /** Number of quantities of the item. */
    private int quantity;

    /***
     * Default constructor of the Item class.
     *
     */
    public Item() {
    }


    public Item(String id, String description, int price, int quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
