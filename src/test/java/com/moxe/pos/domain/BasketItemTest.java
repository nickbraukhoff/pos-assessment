package com.moxe.pos.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @since 12/22/16.
 */
public class BasketItemTest {

    @Test
    public void testSalesTaxIsCalculatedNonGroceryItem() {
        final Item item = new Item("1", TradeType.IMPORT, "Coffee", 15001.25);

        final SimpleBasketItem simpleBasketItem = new SimpleBasketItem(item, 1);

        final double salesTax = simpleBasketItem.calculateSalesTax();
        final double total = simpleBasketItem.calculateTotal();
        Assert.assertEquals("salesTax is not equal", 2250.25, salesTax, 0);
        Assert.assertEquals("total is not equal", 17251.5, total, 0);
    }

    @Test
    public void testSalesTaxIsNotCalculatedForGroceryItem() {
        final SimpleBasketItem simpleBasketItem = new SimpleBasketItem(getItem(true), 1);
        final double salesTax = simpleBasketItem.calculateSalesTax();
        Assert.assertEquals("salesTax is not equal", 0.5, salesTax, 0);
    }

    private class SimpleBasketItem extends BasketItem {

        SimpleBasketItem(final Item item, final int quantity) {
            super(item, quantity);
        }

        @Override
        double additionalSaleTax() {
            return item.getPrice() * .05;
        }
    }

    private Item getItem(final boolean isGroceryItem) {
        final Item item = new Item("1", TradeType.OTHER, "Coffee", 10.00);
        item.setGrocery(isGroceryItem);
        return item;
    }
}
