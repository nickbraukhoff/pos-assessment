package com.moxe.pos.domain;

/**
 * @since 12/22/16.
 */
public class DomesticBasketItem extends BasketItem {

    public DomesticBasketItem(final Item item, final int quantity) {
        super(item, quantity);
    }

    double additionalSaleTax() {
        return 0;
    }
}
