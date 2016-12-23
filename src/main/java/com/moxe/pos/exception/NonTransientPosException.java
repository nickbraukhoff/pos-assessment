package com.moxe.pos.exception;

/**
 * @since 12/22/16.
 */
public class NonTransientPosException extends PosException {
    public NonTransientPosException(final String message) {
        super(message);
    }
}
