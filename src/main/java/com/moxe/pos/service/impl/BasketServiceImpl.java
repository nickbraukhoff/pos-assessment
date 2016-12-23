package com.moxe.pos.service.impl;

import com.moxe.pos.dao.ItemDao;
import com.moxe.pos.domain.BasketItem;
import com.moxe.pos.dto.ItemQuantity;
import com.moxe.pos.mapper.ItemQuantityMapper;
import com.moxe.pos.service.BasketService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return Collections.unmodifiableList(
                Optional.ofNullable(itemQuantities).orElseGet(ArrayList::new)
                        .stream()
                        .map(itemQuantity -> (BasketItem)
                                itemQuantityMapper.apply(
                                        itemDao.getItem(itemQuantity.getItemId()), itemQuantity.getQuantity()
                                ))
                        .collect(Collectors.toList()));
    }
}
