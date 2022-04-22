package com.company;

public class Player extends Thread {

    private int sumOfPlayer;

    public Player(String name) {
        super(name);
    }

    public int getSumOfPlayer() {
        return sumOfPlayer;
    }

    @Override
    public void run() {
        int var;
        while (true) {
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                return;
            }
            var = (int) (Math.random() * (100 - 1) + 1);
            sumOfPlayer += var;
            System.out.println(getName() + ": " + var);
        }

    }
}
