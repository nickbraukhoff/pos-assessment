package com.moxe.pos.mapper.impl;

import com.moxe.pos.domain.*;
import com.moxe.pos.exception.DataException;
import com.moxe.pos.mapper.ItemQuantityMapper;

/**
 * @since 12/22/16.
 */
public class BasketItemQuantityMapper implements ItemQuantityMapper<BasketItem> {

    @Override
    public BasketItem apply(final Item item, final int quantity) {
        if (item != null) {
            return map(item, quantity);
        } else {
            throw new DataException("Unable to create BasketItem. Input Item was null");
        }
    }

    private BasketItem map(final Item item, final int quantity) {
        if (TradeType.IMPORT.equals(item.getTradeType())) {
            return new ImportedBasketItem(item, quantity);
        } else if (TradeType.OTHER.equals(item.getTradeType())) {
            return new DomesticBasketItem(item, quantity);
        } else {
            throw new DataException("Unable to create BasketItem. " + item.getTradeType() + " does not exist", String.valueOf(item.getTradeType()));
        }

    }
}
