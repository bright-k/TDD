package com.eb.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by H on 2018. 12. 7.
 */
public class BaseBallGameTest {
    private static final int GOAL = 123;
    private static final int CHANCE = 10;

    private BaseBallGame game;

    @Before
    public void setUp() {
        game = new BaseBallGame(GOAL, CHANCE);
    }

    @Test
    public void whenChanceOverThrownException() {
        Exception ex = null;
        try {
            for (int i = 0; i < CHANCE + 1; i++) {
                game.guess(123);
            }
        } catch (GameOverException goe) {
            ex = goe;
        }

        assertThat(ex).isInstanceOf(GameOverException.class);
    }

    @Test
    public void whenWrongGuessAllReturnZeroBallZeroStrike() {
        assertGuestScore(456, 0, 0);
        assertGuestScore(789, 0, 0);
    }

    @Test
    public void whenGuessAndGoalSameReturnThreeStrike() {
        assertGuestScore(GOAL, 3, 0);
    }

    @Test
    public void whenGuessOnePredictStrikeReturnOneStrikeZeroBall() {
        assertGuestScore(145, 1, 0);
        assertGuestScore(729, 1, 0);
        assertGuestScore(783, 1, 0);
    }

    @Test
    public void whenGuessTwoPredictStrikeReturnTwoStrikeZeroBall() {
        assertGuestScore(129, 2, 0);
        assertGuestScore(723, 2, 0);
        assertGuestScore(183, 2, 0);
    }

    @Test
    public void whenGuessOnePredictBallReturnZeroStrikeOneBall() {
        assertGuestScore(719, 0, 1);
        assertGuestScore(782, 0, 1);
        assertGuestScore(389, 0, 1);
    }

    @Test
    public void whenGuessMixedPredictStrikeAndBall() {
        assertGuestScore(134, 1, 1);
        assertGuestScore(321, 1, 2);
    }

    private void assertGuestScore(int guess, int strike, int ball) {
        Score score = game.guess(guess);
        assertThat(score).isEqualTo(new Score(strike, ball));
    }

}
