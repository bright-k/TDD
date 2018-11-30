package com.eb.moneys;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by H on 2018. 11. 30.
 */

public class MoneysTest {

    @Test
    public void testMoneysMultipliers() {
        Dollar five = new Dollar(5);

        Dollar product = five.times(2);
        assertEquals(10, product.amount);

        product = five.times(3);
        assertEquals(15, product.amount);
    }

    @Test
    public void testMoneysEquality() {
        Dollar dollar1 = new Dollar(5);
        Dollar dollar2 = new Dollar(5);
        Dollar dollar3 = new Dollar(7);

        assertEquals(dollar1, dollar2);
        assertNotEquals(dollar1, dollar3);
    }
}
