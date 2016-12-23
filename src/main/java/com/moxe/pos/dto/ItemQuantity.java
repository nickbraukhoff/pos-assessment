package com.moxe.pos.dto;

/**
 * @since 12/21/16.
 */
public class ItemQuantity {
    private String itemId;
    private int quantity;

    public ItemQuantity() {
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
