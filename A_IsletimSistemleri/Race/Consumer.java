package A_IsletimSistemleri.Race;

public class Consumer implements Runnable{

    private Buffer sharedLocation;
    public Consumer (Buffer shared){
        sharedLocation = shared;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int count = 0; count <= 1000; count++) {
            try {
                //Thread.sleep((long)(Math.random()*1000));
                sum += sharedLocation.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Consumer exits with reading in total" + sum );

    }

    
    
}
