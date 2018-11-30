package com.eb.moneys;

/**
 * Created by H on 2018. 11. 30.
 */
public class Money {
    protected int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public Money times(int multipliers) {
        return new Money(amount * multipliers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || false == o instanceof Money) return false;

        Money money = (Money) o;

        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }
}
