package A_IsletimSistemleri.RaceCondition;

import java.util.Random;

public class Producer implements Runnable {

    private Buffer sharedLocation;

    public Producer(Buffer shared)
    {

        sharedLocation = shared;

    }

    public void run()
    {
        int sum = 0;

        Random rndGenerator= new Random();

        for (int count = 1; count <=10 ; count++) {

            try {
                Thread.sleep(rndGenerator.nextInt(3000));
                sharedLocation.set(count);
                sum+=count;
            }
            catch (Exception e)
            {

                System.out.println(e.getMessage());
            }




        }

        System.out.println("Producer generates in total "+sum);


    }


}
