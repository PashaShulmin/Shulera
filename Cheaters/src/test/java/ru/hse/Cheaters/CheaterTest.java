package ru.hse.Cheaters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CheaterTest {
    @Test
    void still() {
        FairPlayer fairPlayer = new FairPlayer();
        fairPlayer.increaseScore(10);
        ArrayList<FairPlayer> fairPlayers = new ArrayList<>();
        fairPlayers.add(fairPlayer);
        Cheater cheater = new Cheater(fairPlayers);
        cheater.still(fairPlayer);

        int expected = cheater.getScore();
        int actual = 10 - fairPlayer.getScore();

        Assertions.assertEquals(expected, actual);
    }
}
