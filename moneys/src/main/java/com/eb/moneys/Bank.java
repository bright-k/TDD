package com.eb.moneys;

/**
 * Created by H on 2018. 11. 30.
 */
public class Bank {

    public Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency);
    }
}
