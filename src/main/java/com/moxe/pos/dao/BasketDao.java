package com.moxe.pos.dao;

import com.moxe.pos.dto.ItemQuantity;

import java.util.List;
import java.util.Map;

/**
 * @since 12/23/16.
 */
public interface BasketDao {
    Map<String, List<ItemQuantity>> getBaskets();
}
