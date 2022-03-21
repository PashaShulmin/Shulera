package ru.hse.Cheaters;

import java.util.ArrayList;

/**
 * Класс Шулера наследуется от FairPlayer
 * isFirstMove - переменная определяющая первый ли раз делает ход шулер
 * fairPlayers - ArrayList честных игроков для рандомного выбора того из них, у кого украсть карты
 * cheatersCounter - статическое поле для подсчёта количества созданных
 * экземпляров данного класса и создания уникального имени
 * name - имя игрока
 */
public class Cheater extends FairPlayer {
    private boolean isFirstMove;
    private final ArrayList<FairPlayer> fairPlayers;
    private static int cheatersCounter = 0;
    private final String name;


    /**
     * @return имя шулера
     */
    @Override
    public String getPlayerName() {
        return name;
    }

    /**
     * Метод ограбления. Количество очков шулера увеличивается на столько,
     * на сколько уменьшается количество очков честного игрока
     * @param fairPlayer игрок, которого грабят
     */
    public void still(FairPlayer fairPlayer) {
        increaseScore(fairPlayer.decreaseScore(random.nextInt(0, 9)));
    }

    /**
     * @param fairPlayers ArrayList честных игроков
     */
    public Cheater(ArrayList<FairPlayer> fairPlayers) {
        this.fairPlayers = new ArrayList<>(fairPlayers);
        isFirstMove = true;
        name = "Cheater " + ++cheatersCounter;
    }

    /**
     * Переопределённый метод run.
     * Шулер определяет какой вид хода ему сделать, затем либо грабит
     * рандомного честного игрока, либо делает ход, как честный игрок
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            double key = random.nextDouble(1, 1001) / 1000;
            if (isFirstMove || key > 0.4) {
                synchronized (lock) {
                    increaseScore(random.nextInt(1, 11));
                    isFirstMove = false;
                    try {
                        Thread.sleep(random.nextInt(100, 201));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else {
                synchronized (lock) {
                    still(fairPlayers.get(random.nextInt(0, fairPlayers.size())));
                    try {
                        Thread.sleep(random.nextInt(180, 301));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
