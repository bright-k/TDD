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

        if(goal == predict)
            return new Score(3, 0);

        return new Score(0, 0);
    }
}
