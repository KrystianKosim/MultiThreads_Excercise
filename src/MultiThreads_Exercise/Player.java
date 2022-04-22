package MultiThreads_Exercise;

/**
 * Klasa player reprezentuje gracza w grze, posiada on pole sumOfPlayer, czyli sume punktow danego gracza
 */
public class Player extends Thread {

    private int sumOfPlayer;

    public Player(String name) {
        super(name);
    }

    public int getSumOfPlayer() {
        return sumOfPlayer;
    }

    /**
     * Metoda ktora rozpoczyna watek gracza, podczas trwania watku "usypia" danego gracza, jest to symulacja zastanawiania sie,
     * watek trwa do momentu zakonczenia gry przez sedziego(Referee)
     */
    @Override
    public void run() {
        int randomPoints;
        while (true) {
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                return;
            }
            int maxValueOfPoints = 100;
            int minValueOfPoints = 1;
            randomPoints = (int) (Math.random() * (maxValueOfPoints - minValueOfPoints) + minValueOfPoints);
            sumOfPlayer += randomPoints;
            System.out.println(getName() + ": " + randomPoints);
        }

    }
}
