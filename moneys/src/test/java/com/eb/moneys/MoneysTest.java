package com.eb.moneys;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by H on 2018. 11. 30.
 */

public class MoneysTest {

    @Test
    public void testMoneyMultipliers() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));

        five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testMoneyEquality() {
        assertNotEquals(Money.dollar(1), Money.franc(1));

        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(6));

        assertEquals(Money.franc(3), Money.franc(3));
        assertNotEquals(Money.franc(3), Money.franc(4));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }
}
