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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        if (strike != score.strike) return false;
        return ball == score.ball;
    }

    @Override
    public int hashCode() {
        int result = strike;
        result = 31 * result + ball;
        return result;
    }
}
