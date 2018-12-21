package com.eb.tdd;

/**
 * Created by H on 2018. 12. 7.
 */
public class BaseBallGame {
    private int goal;
    private int chance;

    public BaseBallGame(int goal, int chance) {
        this.goal = goal;
        this.chance = chance;
    }

    public Score guess(int predict) throws GameOverException {
        if(chance <= 0)
            throw new GameOverException();
        chance -= 1;

        int strike = 0;
        int ball = 0;

        for(int i = 1; i <= 3; i++) {
            if(getOffsetNumber(goal, i) == getOffsetNumber(predict, i)) {
                ++strike;
            } else {
                for(int j = 1; j <= 3; j++) {
                    if(i == j)
                        continue;

                    if(getOffsetNumber(goal, j) == getOffsetNumber(predict, i)) {
                        ++ball;
                    }
                }
            }
        }

        return new Score(strike, ball);
    }

    private int getOffsetNumber(int num, int offset) {
        switch (offset) {
            case 1:
                return num % 10;
            case 2:
                return (num % 100) / 10;
            case 3:
                return num / 100;
            default:
                return -1;
        }
    }
}
