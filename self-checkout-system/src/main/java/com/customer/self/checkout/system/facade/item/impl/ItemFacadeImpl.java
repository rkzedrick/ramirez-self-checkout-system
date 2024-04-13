package com.customer.self.checkout.system.facade.item.impl;


import com.customer.self.checkout.system.data.dao.item.ItemDAO;
import com.customer.self.checkout.system.exceptions.ItemExistException;
import com.customer.self.checkout.system.facade.item.ItemFacade;
import com.customer.self.checkout.system.model.item.Item;

import java.sql.SQLException;
import java.util.List;

public class ItemFacadeImpl implements ItemFacade {
    private ItemDAO ItemDAO;

    public ItemFacadeImpl() {
        this.ItemDAO =ItemDAO;
    }


    @Override
    public List<Item> getAllItems() {
        try {
            return ItemDAO.getAllItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item getItemById(String id) {
        return ItemDAO.getItemById(id);
    }

    @Override
    public List<Item> getItemsByIdList(List<String> ids) {
        return ItemDAO.getItemsByIdList(ids);
    }

    @Override
    public boolean addItem(Item item) throws ItemExistException {
        boolean result = false;
        Item targetItem = getItemById(item.getId());
        if(targetItem != null) {
            throw new ItemExistException("Item to add already exists. ");
        }
        result = ItemDAO.addItem(item);
        return result;
    }



}
