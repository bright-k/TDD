package com.eb.tdd;

/**
 * Created by H on 2018. 12. 7.
 */
public class Score {
    private int strike;
    private int ball;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int strike() {
        return strike;
    }

    public int ball() {
        return ball;
    }
}
