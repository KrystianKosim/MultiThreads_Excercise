package com.company;

/**
 * Klasa Referee reprezentuje sedziego. Klasa ma pole players ktore przechowuje graczy w tablicy, oraz time czyli czas jaki trwa gra
 */
public class Referee extends Thread {

    private Player[] players;
    private int time;

    public Referee(int time, Player[] players) {
        this.players = players;
        this.time = time;
    }

    /**
     * Metoda rozpoczyna watek sedziego, co sekunde pokazuje aktualny czas w sekundach, po uplywie czasu podanego w konstruktorze,
     * sedzia konczy gre i zatrzymuje watki graczy
     */
    @Override
    public void run() {
        int i = 1;
        while (i <= time) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Czas " + i++);
        }
        players[0].interrupt();
        players[1].interrupt();

        System.out.println();
    }

    /**
     * Metoda rozpoczyna gre, czyli zaczyna watek sedziego oraz graczy ktorzy biora udzial w grze
     */
    public void startGame() {
        start();
        players[0].start();
        players[1].start();
    }

    /**
     * Metoda wyswietla sume punktow danych graczy oraz informuje o tym ktory wygral
     */
    public void result() {
        System.out.println("Wyniki " + players[0].getName() + ": " + players[0].getSumOfPlayer());
        System.out.println("Wyniki " + players[1].getName() + ": " + players[1].getSumOfPlayer());
        if (players[0].getSumOfPlayer() > players[1].getSumOfPlayer()) {
            System.out.println('\n' + players[0].getName() + " wygral!");
        } else {
            System.out.println('\n' + players[1].getName() + " wygral!");
        }
    }
}
