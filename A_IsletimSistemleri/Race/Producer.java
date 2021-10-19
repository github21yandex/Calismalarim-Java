package A_IsletimSistemleri.Race;

public class Producer implements Runnable {

    private Buffer sharedLocation;

    public Producer(Buffer shared) {
        sharedLocation = shared;
    }

    public void run() {
        int sum = 0;

        for (int count = 0; count <= 10; count++) {
            try {
                //Thread.sleep(   (long)(     Math.random()*1000     )   );
                sharedLocation.set(count);
                sum += count;
            } catch (Exception e) {
                e.printStackTrace();
            }
                        
        }

        System.out.println("producer generates in total " + sum);
    }
}
