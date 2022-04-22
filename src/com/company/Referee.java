package com.company;

public class Referee extends Thread {

    private Player[] players;
    private int time;

    public Referee(int time, Player[] players) {
        this.players = players;
        this.time = time;
    }

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


    public void startGame() {
        start();
        players[0].start();
        players[1].start();
    }

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
