package random;

import java.security.SecureRandom;

public class App{
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        Game oyun1 = new Game();

        for (int i = 0; i < 10; i++) {
            System.out.println(i + "=" + random.nextInt());
            
        }

        System.out.println("gameStatus = " + oyun1.getGameStatus());


    }
}