package com.moxe.pos.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.moxe.pos.dao.FileDao;
import com.moxe.pos.dao.ItemDao;
import com.moxe.pos.domain.Item;
import com.moxe.pos.exception.DataException;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @since 12/23/16.
 */
public class ItemDaoImpl extends FileDao<Map<String, Item>> implements ItemDao {

    public ItemDaoImpl() {
        super(new HashMap<>(), "Items.json");
    }

    ItemDaoImpl(final String fileName) {
        super(new HashMap<>(), fileName);
    }

    @Override
    protected void readFileAndMap() throws IOException {
        final List<Item> items = mapper.readValue(getFile(), new TypeReference<List<Item>>() {
        });
        if (CollectionUtils.isNotEmpty(items)) {
            for (Item item : items) {
                itemMap.put(item.getId(), item);
            }
        } else {
            throw new DataException("No items found in file");
        }
    }

    @Override
    public Item getItem(final String itemId) {
        final Item item = itemMap.get(itemId);
        if (item != null) {
            return itemMap.get(itemId);
        } else {
            throw new DataException("Item not found for id: [{}]", itemId);
        }
    }
}
