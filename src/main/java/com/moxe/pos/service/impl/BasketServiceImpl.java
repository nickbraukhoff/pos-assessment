package com.moxe.pos.service.impl;

import com.moxe.pos.dao.ItemDao;
import com.moxe.pos.domain.BasketItem;
import com.moxe.pos.dto.ItemQuantity;
import com.moxe.pos.mapper.ItemQuantityMapper;
import com.moxe.pos.service.BasketService;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 12/22/16.
 */
public class BasketServiceImpl implements BasketService {
    private final ItemDao itemDao;
    private final ItemQuantityMapper itemQuantityMapper;

    public BasketServiceImpl(final ItemDao itemDao, final ItemQuantityMapper basketItemQuantityMapper) {
        this.itemDao = itemDao;
        this.itemQuantityMapper = basketItemQuantityMapper;
    }

    public List<BasketItem> addItems(final List<ItemQuantity> itemQuantities) {
        final List<BasketItem> basketItems = new ArrayList<BasketItem>();
        if (CollectionUtils.isNotEmpty(itemQuantities)) {
            for (final ItemQuantity itemQuantity : itemQuantities) {
                basketItems.add((BasketItem) itemQuantityMapper.apply(itemDao.getItem(itemQuantity.getItemId()), itemQuantity.getQuantity()));
            }
        }

        return basketItems;
    }
}
