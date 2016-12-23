package com.moxe.pos.service;

import com.moxe.pos.domain.BasketItem;
import com.moxe.pos.dto.CheckoutResponse;

import java.util.List;

/**
 * @since 12/21/16.
 */
public interface CheckoutService {
    CheckoutResponse checkOut(List<BasketItem> basketItems);
    String listBasketItems(List<BasketItem> basketItems);
    String getQualifiedSalesTax(double salesTax);
    String getQualifiedTotal(double total);
}
