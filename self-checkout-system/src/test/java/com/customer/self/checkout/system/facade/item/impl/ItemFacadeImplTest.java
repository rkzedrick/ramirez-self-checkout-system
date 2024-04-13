package com.customer.self.checkout.system.facade.item.impl;

import com.customer.self.checkout.system.data.dao.item.ItemDAO;
import com.customer.self.checkout.system.facade.item.ItemFacade;
import com.customer.self.checkout.system.model.item.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.*;

class ItemFacadeImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemFacadeImplTest.class);

    @InjectMocks
    private ItemFacade itemFacade = new ItemFacadeImpl(ItemDao);

    @Mock
    private ItemDAO itemDao;

    @Mock
    private List<Item> itemList;

    @Mock
    private Item item;

    @Mock
    private Item addItem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        item.setId("1");
        addItem.setId("2");
        try {
            when(itemDao.getAllItems()).thenReturn(itemList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    void getAllItems() throws SQLException {
        List expectedList = itemFacade.getAllItems();


        assert(expectedList.equals(itemList));
        verify(itemDao).getAllItems();
    }

    @Test
    void getItemById() {
        when(itemDao.getItemById("1")).thenReturn(item);
        Item expectedItem = itemFacade.getItemById("1");


        assert(expectedItem.equals(item));
        verify(itemDao).getItemById("1");
    }
    @Test
    void addItem() {
        try {
            when(itemFacade.getItemById(addItem.getId())).thenReturn(null);
            when(itemDao.addItem(addItem)).thenReturn(true);

            boolean result = itemFacade.addItem(addItem);


            assert(result == true);
            // Assert that addItem is not in the database
            assert(itemFacade.getItemById("2") == null);

            verify(itemDao).addItem(addItem);
        } catch (Exception e) {


        }
    }
}