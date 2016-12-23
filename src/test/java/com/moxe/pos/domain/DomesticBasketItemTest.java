package com.moxe.pos.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @since 12/22/16.
 */
public class DomesticBasketItemTest {

    @Test
    public void testNoAdditionalSalesTaxIsCalculated() {
        final Item item = new Item("1", TradeType.OTHER,"Coffee", 10.00);
        item.setGrocery(true);

        final DomesticBasketItem importedBasketItem = new DomesticBasketItem(item, 1);
        final double salesTax = importedBasketItem.calculateSalesTax();

        Assert.assertEquals("salesTax is not equal", 0, salesTax, 0);
    }
}
