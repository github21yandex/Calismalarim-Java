package A_IsletimSistemleri.RaceCondition;

import java.util.Random;
public class Consumer implements  Runnable {

    private Buffer sharedLocation;
    public  Consumer (Buffer shared){

        sharedLocation = shared;

    }



    public  void run(){
        int sum = 0;
        Random rnd= new Random();
        for (int count = 0; count <=10 ; count++) {

            try {
                Thread.sleep(rnd.nextInt(3000));
                sum = sum + sharedLocation.get();


            }
            catch(Exception e)
            {

                System.out.println(e.getMessage());
            }

        }
        System.out.println("Consumer exits with reading in total "+sum);

    }
}
