package com.moxe.pos.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.moxe.pos.dao.BasketDao;
import com.moxe.pos.dao.FileDao;
import com.moxe.pos.dto.ItemQuantity;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @since 12/23/16.
 */
public class BasketDaoImpl extends FileDao<Map<String, List<ItemQuantity>>> implements BasketDao {

    public BasketDaoImpl() {
        super(new HashMap<>(), "Baskets.json");
    }

    BasketDaoImpl(final String basketsJsonFileName) {
        super(new HashMap<>(), basketsJsonFileName);
    }

    @Override
    public Map<String, List<ItemQuantity>> getBaskets() {
        return itemMap;
    }

    @Override
    protected void readFileAndMap() throws IOException {
        itemMap.putAll(mapper.readValue(getFile(), new TypeReference<Map<String, List<ItemQuantity>>>() {}));
    }
}
