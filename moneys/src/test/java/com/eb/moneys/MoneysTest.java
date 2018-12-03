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
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Expression sum = Money.dollar(5).plus(Money.dollar(5));
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnsSum() {
        Expression result = Money.dollar(5).plus(Money.dollar(5));
        Sum sum = (Sum)result;
        assertEquals(Money.dollar(5), sum.augend);
        assertEquals(Money.dollar(5), sum.addend);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testReduceMoneyDiffCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testMixedAddition() {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveDollars.plus(tenFrancs), "USD");

        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testSumPlusMoney() {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveDollars, tenFrancs).plus(fiveDollars);
        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testSumTimes() {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveDollars, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(20), result);
    }

}
