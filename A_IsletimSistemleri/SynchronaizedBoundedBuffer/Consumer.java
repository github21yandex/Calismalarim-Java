package A_IsletimSistemleri.SynchronaizedBoundedBuffer;

import java.util.Date;

public class Consumer implements Runnable {
   private Buffer<Date> buffer;

   public Consumer(Buffer<Date> buffer) {
      this.buffer = buffer;
   }
   @SuppressWarnings("unused")
   public void run() {

      Date message;

      while (true) {
         System.out.println("Consumer napping");
         // SleepUtilities.nap();

         // consume an item from the buffer
         System.out.println("Consumer wants to consume.");

         try {
            message = buffer.remove();
         } catch (InterruptedException e) {    e.printStackTrace();    }
        
      }
   }
   
}