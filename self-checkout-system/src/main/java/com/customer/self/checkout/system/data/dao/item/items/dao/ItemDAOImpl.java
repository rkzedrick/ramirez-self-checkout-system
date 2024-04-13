package com.customer.self.checkout.system.data.dao.item.items.dao;

import com.customer.self.checkout.system.data.connectionhelper.ConnectionHelper;
import com.customer.self.checkout.system.data.dao.item.ItemDAO;
import com.customer.self.checkout.system.data.utils.QueryConstants;
import com.customer.self.checkout.system.model.item.Item;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemDAOImpl.class);

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        try (Connection con = new ConnectionHelper().getConnection()){
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_ALL_ITEMS_STATEMENT);
            ResultSet rs= statement.executeQuery();

            while(rs.next()) {
                itemList.add(setItem(rs));
            }
            LOGGER.debug("Items retrieved successfully.");

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Item database is empty.");
        return itemList;
    }

    @Override
    public Item getItemById(String id) {
        Item item = null;
        try (Connection con = new ConnectionHelper().getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_ITEM_BY_ID_STATEMENT);
            statement.setString(1, id);
            ResultSet rs= statement.executeQuery();

            if(rs.next()) {
                LOGGER.debug("Item retrieved successfully.");
                item = setItem(rs);
            }

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Item not found.");
        return item;
    }

    @Override
    public List<Item> getItemsByIdList(List<String> ids) {
        List<Item> itemList = new ArrayList<>();
        try (Connection con = new ConnectionHelper().getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_ITEMS_BY_IDS_STATEMENT);
            for(int i=1; i<=ids.size(); i++) {
                statement.setString(i, ids.get(i-1));
            }
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                itemList.add(setItem(rs));
            }

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        return itemList;
    }

    @Override
    public boolean addItem(Item item) {
        int result = 0;
        try (Connection con = new ConnectionHelper().getConnection()){
            PreparedStatement statement = con.prepareStatement(QueryConstants.ADD_ITEM_STATEMENT);
            statement.setString(1, item.getId());
            statement.setString(2, item.getDescription());
            statement.setInt(3, item.getPrice());
            statement.setInt(4, item.getQuantity());
            result = statement.executeUpdate();
            if(result == 1) {
                LOGGER.debug("Item successfully added.");
                return true;
            }

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Adding item failed.");
        return false;
    }






    private Item setItem(ResultSet rs) {
        try {
            Item item = new Item();
            item.setId(rs.getString("id"));
            item.setDescription(rs.getString("description"));
            item.setPrice(Integer.parseInt(rs.getString("price")));
            item.setQuantity(Integer.parseInt(rs.getString("quantity")));
            return item;
        } catch (SQLException ex) {
        }
        return null;
    }

}
