package com.moxe.pos.dto;

/**
 * @since 12/21/16.
 */
public class ItemQuantity {
    private String itemId;
    private int quantity;

    public ItemQuantity() {
    }

    public ItemQuantity(final String itemId, final int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
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
