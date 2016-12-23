package com.moxe.pos.domain;

import com.moxe.pos.exception.DataException;
import com.moxe.pos.util.CurrencyUtils;

/**
 * @since 12/21/16.
 */
public abstract class BasketItem {
    private static final double SALES_TAX = .10;
    final Item item;
    private int quantity;

    BasketItem(final Item item, final int quantity) {
        if (item == null) {
            throw new DataException("Item is required");
        }
        this.item = item;
        this.quantity = quantity;
    }

    private double getSubTotal() {
        return item.getPrice() * quantity;
    }

    abstract double additionalSaleTax();

    public double calculateTotal() {
        return getSubTotal() + calculateSalesTax();
    }

    public double calculateSalesTax() {
        double salesTax = 0;
        if (!item.isGrocery()) {
            salesTax += CurrencyUtils.round(getSubTotal() * SALES_TAX);
        }
        return CurrencyUtils.round(additionalSaleTax()) + salesTax;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return quantity + " " + item.toString() + CurrencyUtils.format(calculateTotal());
    }
}
