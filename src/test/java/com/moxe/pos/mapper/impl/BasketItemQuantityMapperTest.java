package com.moxe.pos.mapper.impl;

import com.moxe.pos.domain.*;
import com.moxe.pos.exception.DataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @since 12/22/16.
 */
public class BasketItemQuantityMapperTest {

    private BasketItemQuantityMapper quantityMapper;

    @Before
    public void init() {
        quantityMapper = new BasketItemQuantityMapper();
    }

    @Test(expected = DataException.class)
    public void testDataExceptionIsThrownWhenItemIsNull() {
        final BasketItem basketItem = quantityMapper.apply(null, 2);
    }

    @Test(expected = DataException.class)
    public void testDataExceptionIsThrownWhenTradeTypeIsInvalid() {
        final Item item = new Item("1", null, "WaterMellon", 5.00);
        final BasketItem basketItem = quantityMapper.apply(item, 2);
    }

    @Test
    public void testWhenItemIsNotImportedThenReturnTypeIsDomesticBasketItemType() {
        final Item item = new Item("1", TradeType.OTHER, "WaterMellon", 5.00);
        final BasketItem basketItem = quantityMapper.apply(item, 2);

        Assert.assertTrue("Incorrect type returned", basketItem instanceof DomesticBasketItem);
    }

    @Test
    public void testWhenItemIsImportedThenReturnTypeIsImportedBasketItemType() {
        final Item item = new Item("1", TradeType.IMPORT, "WaterMellon", 5.00);
        final BasketItem basketItem = quantityMapper.apply(item, 2);

        Assert.assertTrue("Incorrect type returned", basketItem instanceof ImportedBasketItem);
    }
}
