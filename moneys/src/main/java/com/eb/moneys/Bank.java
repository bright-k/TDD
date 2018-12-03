package com.eb.moneys;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by H on 2018. 11. 30.
 */
public class Bank {
    private Map<Pair, Integer> rates = new Hashtable<>();

    public Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), Integer.valueOf(rate));
    }

    public int rate(String from, String to) {
        return from.equals(to) ? 1 : rates.get(new Pair(from, to)).intValue();
    }

    private class Pair {
        private String from;
        private String to;

        public Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (from != null ? !from.equals(pair.from) : pair.from != null) return false;
            return to != null ? to.equals(pair.to) : pair.to == null;
        }

        @Override
        public int hashCode() {
            int result = from != null ? from.hashCode() : 0;
            result = 31 * result + (to != null ? to.hashCode() : 0);
            return result;
        }
    }
}
