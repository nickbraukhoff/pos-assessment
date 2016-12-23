package com.moxe.pos.dao.impl;

import com.moxe.pos.domain.Item;
import com.moxe.pos.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @since 12/23/16.
 */
public class ItemDaoImplTest {
    private ItemDaoImpl itemDao;

    @Test(expected = DataException.class)
    public void testExceptionIsThrownWhenItemIsNotFound() {
        itemDao = new ItemDaoImpl("TestItems.json");
        itemDao.getItem("foobar");
    }

    @Test(expected = DataException.class)
    public void testExceptionIsThrownWhenNoDataIsFoundInFile() {
        itemDao = new ItemDaoImpl("EmptyFile.json");

    }

    @Test(expected = DataException.class)
    public void testExceptionIsThrownIncorrectDataStructureIsFoundInFile() {
        itemDao = new ItemDaoImpl("TestBasketsWithValidItems.json");
    }

    @Test
    public void testItemIsReturnedWhenFound() {
        itemDao = new ItemDaoImpl("TestItems.json");
        final Item item = itemDao.getItem("ceba49e2-7aee-4e2d-893c-e7347e24d4b8");
        Assert.assertTrue("Item is null", item != null);
        Assert.assertEquals("Incorrect Item was returned", "ceba49e2-7aee-4e2d-893c-e7347e24d4b8", item.getId());
    }

}
