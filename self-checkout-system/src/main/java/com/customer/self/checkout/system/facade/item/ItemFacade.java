package com.customer.self.checkout.system.facade.item;

import com.customer.self.checkout.system.exceptions.ItemExistException;
import com.customer.self.checkout.system.model.item.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemFacade {
    List<Item> getAllItems() throws SQLException;

    Item getItemById(String id);

    List<Item> getItemsByIdList(List<String> ids);

    boolean addItem(Item item) throws ItemExistException, ItemExistException;

}
