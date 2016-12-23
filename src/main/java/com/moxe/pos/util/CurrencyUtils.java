package com.moxe.pos.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @since 12/23/16.
 */
public final class CurrencyUtils {
    private static final NumberFormat CURRENCY_INSTANCE = NumberFormat.getCurrencyInstance(Locale.US);
    private static final int ROUND_SCALE = 2;
    private static final int VALUE = 20;

    public static String format(final double bigDecimal){
        return CURRENCY_INSTANCE.format(bigDecimal);
    }

    public static double round(final double value) {
        final BigDecimal decimal = new BigDecimal(value);
        BigDecimal result =  new BigDecimal(Math.ceil(decimal.doubleValue() * VALUE) / VALUE);
        return result.setScale(ROUND_SCALE, RoundingMode.HALF_UP).doubleValue();
    }
}
