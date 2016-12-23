package com.moxe.pos.mapper;

import com.moxe.pos.domain.Item;

/**
 * @since 12/23/16.
 */
public interface ItemQuantityMapper<T> {
    T apply(final Item item, final int quantity);
}
