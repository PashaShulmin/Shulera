package ru.hse.Cheaters;

import java.util.ArrayList;

public class Main {

    // main Method
    public static void main(String[] args) throws InterruptedException {
        int fairPlayersNumber = PerformerClass.getFairPlayersNumber();
        int cheatersNumber = PerformerClass.getCheaterNumber();

        ArrayList<FairPlayer> fairPlayers = new ArrayList<>();
        PerformerClass.fillFairPlayers(fairPlayers, fairPlayersNumber);

        ArrayList<Cheater> cheaters = new ArrayList<>();
        PerformerClass.fillCheaters(cheaters, fairPlayers, cheatersNumber);

        for (FairPlayer fairPlayer: fairPlayers) {
            fairPlayer.start();
        }
        for (Cheater cheater: cheaters) {
            cheater.start();
        }

        System.out.println("Идёт игра");
        Thread.sleep(10_000);

        for (FairPlayer fairPlayer: fairPlayers) {
            fairPlayer.interrupt();
        }
        for (Cheater cheater: cheaters) {
            cheater.interrupt();
        }

        Thread.sleep(500);

        int maxScore = -1;
        String winnerName = "";

        for (FairPlayer fairPlayer: fairPlayers) {
            System.out.println(fairPlayer.getPlayerName() + " набрал " + fairPlayer.getScore() + " очков");
            if (fairPlayer.getScore() > maxScore) {
                maxScore = fairPlayer.getScore();
                winnerName = fairPlayer.getPlayerName();
            }
        }
        for (Cheater cheater: cheaters) {
            System.out.println(cheater.getPlayerName() + " набрал " + cheater.getScore() + " очков");
            if (cheater.getScore() > maxScore) {
                maxScore = cheater.getScore();
                winnerName = cheater.getPlayerName();
            }
        }

        Thread.sleep(1500);
        System.out.println("Определяем победителя");
        Thread.sleep(1500);
        System.out.println("Секундочку...");
        Thread.sleep(1500);
        System.out.println("Вы готовы?");
        Thread.sleep(1500);
        System.out.println("Победил " + winnerName + ", он набрал " + maxScore + " очков!!!");
    }
}
