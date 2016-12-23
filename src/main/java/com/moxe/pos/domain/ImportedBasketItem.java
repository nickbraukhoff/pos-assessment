package com.moxe.pos.domain;

/**
 * @since 12/22/16.
 */
public class ImportedBasketItem extends BasketItem {

    public ImportedBasketItem(Item item, int quantity) {
        super(item, quantity);
    }

    double additionalSaleTax() {
        return this.item.getPrice() * .05;
    }
}
