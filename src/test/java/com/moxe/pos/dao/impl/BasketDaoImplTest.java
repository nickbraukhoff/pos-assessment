package com.moxe.pos.dao.impl;

import com.moxe.pos.dto.ItemQuantity;
import com.moxe.pos.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @since 12/23/16.
 */
public class BasketDaoImplTest {
    private BasketDaoImpl basketDao;

    @Test(expected = DataException.class)
    public void testExceptionIsThrownWhenNoDataIsFoundInFile() {
        basketDao = new BasketDaoImpl("EmptyFile.json");

    }

    @Test(expected = DataException.class)
    public void testExceptionIsThrownIncorrectDataStructureIsFoundInFile() {
        basketDao = new BasketDaoImpl("TestItems.json");
    }
    @Test
    public void testValidNumberOfBasketsAndBasketItemsAreReturned(){
        basketDao = new BasketDaoImpl("TestBasketsWithValidItems.json");

        final Map<String, List<ItemQuantity>> itemMap = basketDao.getBaskets();
        Assert.assertTrue("Map is Empty", !itemMap.isEmpty());
        Assert.assertEquals("Invalid map size", 2, itemMap.size());
    }
}
