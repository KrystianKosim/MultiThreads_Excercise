package com.company;

public class TestGame {

    public static void main(String[] args) {
        /**
         * Utworzenie graczy, ktorzy biora udzial w grze
         */
        Player p1 = new Player("Player1");
        Player p2 = new Player("Player2");

        /**
         * Utworzenie arbitra oraz ustawienie czasu trwania gry
         */
        Referee ref = new Referee(10, new Player[]{p1, p2});

        /**
         * Arbiter rozpoczyna gre
         */
        ref.startGame();

        try {

            ref.join();

        } catch (InterruptedException exc) {

            exc.printStackTrace();

        }

        /**
         * Wyswietlenie wynikow
         */
        ref.result();

    }
}