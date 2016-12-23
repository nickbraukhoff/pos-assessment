package com.moxe.pos.service.impl;

import com.moxe.pos.dao.ItemDao;
import com.moxe.pos.domain.BasketItem;
import com.moxe.pos.domain.Item;
import com.moxe.pos.dto.ItemQuantity;
import com.moxe.pos.mapper.ItemQuantityMapper;
import com.moxe.pos.service.BasketService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 12/22/16.
 */
public class BasketServiceImplTest {

    private BasketService basketService;

    @Before
    public void init() {
        final ItemDao itemDao = Mockito.mock(ItemDao.class);
        final ItemQuantityMapper itemQuantityMapper = Mockito.mock(ItemQuantityMapper.class);
        final BasketItem basketItem = Mockito.mock(BasketItem.class);

        Mockito.when(itemDao.getItem(Mockito.anyString())).thenReturn(new Item());
        Mockito.when(itemQuantityMapper.apply(Mockito.any(Item.class), Mockito.anyInt())).thenReturn(basketItem);

        basketService = new BasketServiceImpl(itemDao, itemQuantityMapper);
    }

    @Test
    public void testEmptyListIsReturnedWhenInputListIsNull() {
        final List<BasketItem> basketItems = basketService.addItems(null);
        Assert.assertTrue("List is not empty", CollectionUtils.isEmpty(basketItems));
    }

    @Test
    public void testEmptyListIsReturnedWhenInputListIsEmpty() {
        final List<BasketItem> basketItems = basketService.addItems(new ArrayList<>());
        Assert.assertTrue("List is not empty", CollectionUtils.isEmpty(basketItems));
    }

    @Test
    public void testListIsReturnedWithCorrectSizeWhenInputListHasItems() {
        final List<BasketItem> basketItems = basketService.addItems(getItemQuantities());
        Assert.assertTrue("List is empty", CollectionUtils.isNotEmpty(basketItems));
        Assert.assertEquals("List size is invalid", 2, basketItems.size());
    }

    private List<ItemQuantity> getItemQuantities() {
        final List<ItemQuantity> itemQuantities = new ArrayList<>();
        itemQuantities.add(new ItemQuantity());
        itemQuantities.add(new ItemQuantity());
        return itemQuantities;
    }
}
