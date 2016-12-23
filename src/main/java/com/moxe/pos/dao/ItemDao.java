package com.moxe.pos.dao;

import com.moxe.pos.domain.Item;

/**
 * @since 12/23/16.
 */
public interface ItemDao {
    Item getItem(String itemId);
}
