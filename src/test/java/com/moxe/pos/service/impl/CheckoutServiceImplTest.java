package com.moxe.pos.service.impl;

import com.moxe.pos.domain.BasketItem;
import com.moxe.pos.service.CheckoutService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 12/23/16.
 */
public class CheckoutServiceImplTest {
    private CheckoutService checkoutService;

    @Before
    public void init() {
        checkoutService = new CheckoutServiceImpl();
    }

    @Test
    public void testValidFormatForNullListOfBasketItems() {
        final String value = checkoutService.listBasketItems(null);
        Assert.assertEquals("BasketItem List is invalid", "", value);
    }

    @Test
    public void testValidFormatForEmptyListOfBasketItems() {
        final String value = checkoutService.listBasketItems(new ArrayList<>());
        Assert.assertEquals("BasketItem List is invalid", "", value);
    }

    @Test
    public void testValidFormatForListOfBasketItems() {
        final String value = checkoutService.listBasketItems(getBasketItems());
        Assert.assertEquals("BasketItem List is invalid", "\t Foobar\n" + "\t Foobar", value);
    }

    @Test
    public void testValidFormatForQualifiedSalesTax() {
        final String value = checkoutService.getQualifiedSalesTax(12.34);
        Assert.assertEquals("Sales Tax output is invalid", "\t Sales Taxes: $12.34", value);
    }

    @Test
    public void testValidFormatForQualifiedTotal() {
        final String value = checkoutService.getQualifiedTotal(12.34);
        Assert.assertEquals("Sales Tax output is invalid", "\t Total: $12.34", value);
    }

    private static List<BasketItem> getBasketItems() {
        final BasketItem basketItem = Mockito.mock(BasketItem.class);
        Mockito.when(basketItem.toString()).thenReturn("Foobar");
        final List<BasketItem> basketItems = new ArrayList<>();
        basketItems.add(basketItem);
        basketItems.add(basketItem);
        return basketItems;
    }

}
