package ru.hse.Cheaters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FairPlayerTest {
    @Test
    void increaseScoreTest() {
        FairPlayer player = new FairPlayer();
        player.increaseScore(5);

        int expected = 5;
        int actual = player.getScore();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void decreaseScoreTest1() {
        FairPlayer player = new FairPlayer();
        player.increaseScore(10);
        player.decreaseScore(5);

        int expected = 5;
        int actual = player.getScore();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void decreaseScoreTest2() {
        FairPlayer player = new FairPlayer();
        player.increaseScore(3);
        player.decreaseScore(5);

        int expected = 0;
        int actual = player.getScore();

        Assertions.assertEquals(expected, actual);
    }
}
