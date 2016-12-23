package com.moxe.pos.service.impl;

import com.moxe.pos.domain.BasketItem;
import com.moxe.pos.dto.CheckoutResponse;
import com.moxe.pos.service.CheckoutService;
import com.moxe.pos.util.CurrencyUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @since 12/21/16.
 */
public class CheckoutServiceImpl implements CheckoutService {

    public CheckoutResponse checkOut(final List<BasketItem> basketItems) {
        double taxes = 0;
        double total = 0;

        for (final BasketItem basketItem : basketItems) {
            taxes += basketItem.calculateSalesTax();
            total += basketItem.calculateTotal();
        }

        return new CheckoutResponse(basketItems, taxes, total);
    }

    public String listBasketItems(final List<BasketItem> basketItems) {
        final StringBuilder stringBuilder = new StringBuilder();
        if (CollectionUtils.isNotEmpty(basketItems)) {
            for (int i = 0; i < basketItems.size(); i++) {
                stringBuilder.append("\t " + basketItems.get(i).toString());
                if (i != basketItems.size() - 1) {
                    stringBuilder.append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }

    public String getQualifiedSalesTax(final double salesTax) {
        return "\t Sales Taxes: " + CurrencyUtils.format(salesTax);

    }

    public String getQualifiedTotal(final double total) {
        return "\t Total: " + CurrencyUtils.format(total);
    }

}
