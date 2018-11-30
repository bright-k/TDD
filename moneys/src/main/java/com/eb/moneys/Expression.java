package com.eb.moneys;

/**
 * Created by H on 2018. 11. 30.
 */
public interface Expression {
    Money reduce(String toCurrency);
}
