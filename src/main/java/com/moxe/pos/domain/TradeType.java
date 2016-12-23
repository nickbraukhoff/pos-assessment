package com.moxe.pos.domain;

/**
 * @since 12/22/16.
 */
public enum TradeType {
    IMPORT("imported"), OTHER(null);

    private String value;
    TradeType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
