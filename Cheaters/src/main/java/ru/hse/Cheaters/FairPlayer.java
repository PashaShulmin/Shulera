package ru.hse.Cheaters;

import java.util.Random;

/**
 * Класс честного игрока наследуется от Thread
 * lock - объект для синхронизации потоков
 * playersCounter - статическое поле для подсчёта количества созданных
 * экземпляров данного класса и создания уникального имени
 * name - имя игрока
 * score - очки игрока
 * random - переменная для генерации рандомных значений
 */
public class FairPlayer extends Thread {
    protected static final Object lock = new Object();
    private static int playersCounter = 0;
    private final String name;
    protected int score;
    protected Random random;

    /**
     * @return имя честного игрока
     */
    public String getPlayerName() {
        return name;
    }

    /**
     * @return текущее количество очков
     */
    public int getScore() {
        return score;
    }

    /**
     * Метод, уменьшающий очки
     * @param value число, на которое нужно уменьшить очки
     * @return число, на которое были уменьшены очки
     */
    public int decreaseScore(int value) {
        if (score < value) {
            value = score;
        }
        score -= value;
        return value;
    }

    /**
     * Метод, увеличивающий очки
     * @param value число, на которое нужно увеличить очки
     */
    public void increaseScore(int value) {
        score += value;
    }

    /**
     * Конструктор. Очки изначально равны нулю. Определяем имя игрока
     */
    public FairPlayer() {
        score = 0;
        name = "Fair player " + ++playersCounter;
        random = new Random();
    }

    /**
     * Переопределённый метод run.
     * Игрок пытается увеличить количество очков на число от 1 до 10,
     * затем отдыхает от 100 до 200 м. сек.
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                increaseScore(random.nextInt(1, 11));
                try {
                    Thread.sleep(100, 201);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
