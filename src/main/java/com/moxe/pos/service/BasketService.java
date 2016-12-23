package com.moxe.pos.service;

import com.moxe.pos.domain.BasketItem;
import com.moxe.pos.dto.ItemQuantity;

import java.util.List;

/**
 * @since 12/22/16.
 */
public interface BasketService {
    List<BasketItem> addItems(List<ItemQuantity> itemQuantities);
}
