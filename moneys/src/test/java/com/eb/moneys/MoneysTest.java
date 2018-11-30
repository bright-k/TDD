package com.eb.moneys;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by H on 2018. 11. 30.
 */

public class MoneysTest {

    @Test
    public void testMoneyMultipliers() {
        Money five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));

        five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }

    @Test
    public void testMoneyEquality() {
        assertEquals(new Dollar(5), new Dollar(5));
        assertNotEquals(new Dollar(5), new Dollar(6));

        assertEquals(new Franc(3), new Franc(3));
        assertNotEquals(new Franc(3), new Franc(4));
    }

}
