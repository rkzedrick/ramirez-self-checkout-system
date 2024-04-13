package com.customer.self.checkout.system.data.dao.item.impl;

import com.customer.self.checkout.system.data.dao.item.ItemDAO;
import com.customer.self.checkout.system.model.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ItemDAOImplTest {
    private ItemDAO itemDAO;

    private List<Item> itemList;

    @BeforeEach
    public void setup() {
        itemList = new ArrayList<>();
        Item item1 = new Item("1", "Coocoo Cola", 50, 5);
        Item item2 = new Item("2", "Gardenya", 25, 5);
        itemList.add(item1);
        itemList.add(item2);

        itemDAO = mock(ItemDAO.class);
    }

    @Test
    void getAllItems() throws SQLException {
        when(itemDAO.getAllItems()).thenReturn(itemList);

        List<Item> expectedResult = itemDAO.getAllItems();

        //Assertion Part
        assertEquals(expectedResult.size(), 2);
        assertNotEquals(expectedResult, null);
    }

    @Test
    void getItemById() {
        Item item1 = new Item("1", "Coocoo Cola", 50, 3);

        when(itemDAO.getItemById("1")).thenReturn(item1);

        Item expectedItem = itemDAO.getItemById("1");

        assertEquals(expectedItem, item1);
        assertEquals(expectedItem.getDescription(), item1.getDescription());
    }

}