package com.moxe.pos.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @since 12/22/16.
 */
public class ImportedBasketItemTest {

    @Test
    public void testAdditionalSalesTaxIsCalculatedItem() {
        final Item item = new Item("1", TradeType.IMPORT, "Coffee", 10);

        final ImportedBasketItem importedBasketItem = new ImportedBasketItem(item, 1);
        final double salesTax = importedBasketItem.calculateSalesTax();

        Assert.assertEquals("salesTax is not equal", 1.50, salesTax, 0);
    }
}
