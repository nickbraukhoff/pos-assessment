package com.moxe.pos.dto;

import com.moxe.pos.domain.BasketItem;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 12/21/16.
 */
public class CheckoutResponse {
    private final List<BasketItem> basketItems = new ArrayList<BasketItem>();
    private final double salesTax;
    private final double total;

    public CheckoutResponse(final List<BasketItem> basketItems, final double salesTax, final double total) {
        if(CollectionUtils.isNotEmpty(basketItems)){
            this.basketItems.addAll(basketItems);
        }
        this.salesTax = salesTax;
        this.total = total;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getTotal() {
        return total;
    }
}
