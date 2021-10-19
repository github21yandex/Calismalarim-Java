package A_IsletimSistemleri.SynchronaizedBoundedBuffer;

import java.util.Date;

public class Producer implements Runnable {
    private Buffer<Date> buffer;

    public Producer(Buffer<Date> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        Date message;

        while (true) {
            System.out.println("Producer napping");
            // leepUtilities.nap();

            // produce an item & enter it into the buffer
            message = new Date();
            System.out.println("Producer produced " + message);

            try {
                buffer.insert(message);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
		}
	}
	
}
