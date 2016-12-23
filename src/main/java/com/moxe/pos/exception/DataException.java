package com.moxe.pos.exception;

/**
 * @since 12/22/16.
 */
public class DataException extends NonTransientPosException {
    private String data;

    public DataException(final String message) {
        super(message);
    }

    public DataException(final String message, final String data) {
        super(message);
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
