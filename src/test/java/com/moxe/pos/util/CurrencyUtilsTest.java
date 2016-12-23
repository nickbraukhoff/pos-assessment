package com.moxe.pos.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @since 12/23/16.
 */
public class CurrencyUtilsTest {

    @Test
    public void testCurrencyFormatIsUS() {
        final String value = CurrencyUtils.format(1.23);
        Assert.assertEquals("Currency format is incorrect", "$1.23", value);
    }

    @Test
    public void testValueIsNOTRoundedWhenHundredthsPlaceIsAMultipleOf5() {
        final double value = CurrencyUtils.round(1.05);

        Assert.assertEquals("Value was not rounded down correctly", 1.05, value, 0);
    }

    @Test
    public void testValueIsRoundedWhenThousandthPlaceIsAMultipleOf5() {
        final double value = CurrencyUtils.round(1.005);

        Assert.assertEquals("Value was not rounded down correctly", 1.05, value, 0);
    }

    @Test
    public void testValueIsRoundedToNearestMultipleOf5ForHundredthsPlace() {
        final double value = CurrencyUtils.round(1.06);

        Assert.assertEquals("Value was not rounded down correctly", 1.1, value, 0);
    }

    @Test
    public void testValueIsRoundedToNearestMultipleOf5ForThousandth() {
        final double value = CurrencyUtils.round(1.006);

        Assert.assertEquals("Value was not rounded down correctly", 1.05, value, 0);
    }

    @Test
    public void testValueIsRoundedToNearestMultipleOf5ForTenThousandth() {
        final double value = CurrencyUtils.round(1.0006);

        Assert.assertEquals("Value was not rounded down correctly", 1.05, value, 0);
    }



}
