package A_IsletimSistemleri.DiningPhilosopher;

public class App {
    public static void main(String[] args) {
        

        //Philosopher [] philosopherArray = new Philosopher [5];

        Thread [] philosopher = new Thread[5];
        
        for (int i = 0; i < philosopher.length; i++) {
            philosopher[i] = new Thread( new Philosopher() );
        }

        for (int i = 0; i < philosopher.length; i++) {
            philosopher[i].start();
        }
    }
}
