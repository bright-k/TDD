package com.eb.moneys;

/**
 * Created by H on 2018. 11. 30.
 */
public class Sum implements Expression {
    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String toCurrency) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, toCurrency);
    }
}
