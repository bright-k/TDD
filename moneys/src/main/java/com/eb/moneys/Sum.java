package com.eb.moneys;

/**
 * Created by H on 2018. 11. 30.
 */
public class Sum implements Expression {
    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String toCurrency) {
        int amount = augend.reduce(bank, toCurrency).amount+ addend.reduce(bank, toCurrency).amount;
        return new Money(amount, toCurrency);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multipliers) {
        return new Sum(augend.times(multipliers), addend.times(multipliers));
    }
}
