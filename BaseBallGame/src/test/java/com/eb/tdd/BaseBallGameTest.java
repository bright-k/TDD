package com.eb.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;


/**
 * Created by H on 2018. 12. 7.
 */
public class BaseBallGameTest {

    private BaseBallGame game;

    @Before
    public void setUp() {

    }

    @Test
    public void whenChanceOverThrownException() {
        game = new BaseBallGame(789, 1);

        Exception ex = null;
        try {
            for (int i = 0; i < 2; i++) {
                game.guess(123);
            }
        } catch (GameOverException goe) {
            ex = goe;
        }

        assertTrue(ex instanceof GameOverException);
    }

    @Test
    public void whenWrongGuessAllReturnZeroBallZeroStrike() {
        game = new BaseBallGame(789, 10);

        assertGuestScore(123, 0, 0);
        assertGuestScore(456, 0, 0);
    }

    @Test
    public void whenGuessAndGoalSameReturnThreeStrike() {
        game = new BaseBallGame(123, 1);
        assertGuestScore(123, 3, 0);
    }

    private void assertGuestScore(int guess, int strike, int ball) {
        Score score = game.guess(guess);
        assertThat(strike, equalTo(score.strike()));
        assertThat(ball, equalTo(score.ball()));
    }

}
