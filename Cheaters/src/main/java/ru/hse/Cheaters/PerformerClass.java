package ru.hse.Cheaters;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Вспомогательный метод для инициализации данных
 */
public class PerformerClass {
    private static final Scanner in = new Scanner(System.in);

    /**
     * Метод добивается от пользователя введения целого числа из нужного диапазона
     * и выводит различные предупреждения
     * @return количество честных игроков
     */
    public static int getFairPlayersNumber() {
        int fairPlayersNumber;
        do {
            System.out.println("Введите количество честных игроков, это должно быть целое число от 1 до 20");
            while (!in.hasNextInt()) {
                System.out.println("Это не число");
                in.next();
            }
            fairPlayersNumber = in.nextInt();
        } while (fairPlayersNumber < 1 || fairPlayersNumber > 20);
        return fairPlayersNumber;
    }

    /**
     * Метод добивается от пользователя введения целого числа из нужного диапазона
     * и выводит различные предупреждения
     * @return количество шулеров
     */
    public static int getCheaterNumber() {
        int cheatersNumber;
        do {
            System.out.println("Введите количество шулеров, это должно быть целое число от 1 до 20");
            while (!in.hasNextInt()) {
                System.out.println("Это не число");
                in.next();
            }
            cheatersNumber = in.nextInt();
        } while (cheatersNumber < 1 || cheatersNumber > 20);
        return cheatersNumber;
    }

    /**
     * Метод заполняет список честными игроками, готовыми к игре
     * @param fairPlayers список честных игроков
     * @param size количество честных игроков
     */
    public static void fillFairPlayers(ArrayList<FairPlayer> fairPlayers, int size) {
        for (int i = 0; i < size; ++i) {
            fairPlayers.add(new FairPlayer());
        }
    }

    /**
     * Метод заполняет список шулерами, готовыми к игре
     * @param cheaters список шулеров
     * @param fairPlayers список честных игроков, т.к. для создания шулера нам нужен список честных игроков
     * @param size количество шулеров
     */
    public static void fillCheaters(ArrayList<Cheater> cheaters, ArrayList<FairPlayer> fairPlayers, int size) {
        for (int i = 0; i < size; i++) {
            cheaters.add(new Cheater(fairPlayers));
        }
    }
}
