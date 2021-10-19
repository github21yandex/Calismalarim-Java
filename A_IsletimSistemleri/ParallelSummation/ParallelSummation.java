
package A_IsletimSistemleri.ParallelSummation;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ParallelSummation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        // int globaTotal = 0;
        Random rnd = new Random();

        int elementCount= 100;
        int [] array = new int [elementCount];
        int threadCount=9;
        ReentrantLock lock =new ReentrantLock();
        
        for (int i = 0; i < array.length; i++) {
             array[i]= rnd.nextInt(50);
            
        }
        
      //   MutableInteger[] sumValue=new MutableInteger[threadCount];
         MutableInteger sumValue2 = new MutableInteger(0);
       /*  for (int i = 0; i < sumValue.length; i++) {
             sumValue[i] = new MutableInteger(0);
        }*/
         
        Thread[] sumThreads = new Thread[threadCount];
        int amount = (int)Math.ceil((double)elementCount/threadCount);
        
        for (int i = 0; i < sumThreads.length; i++) {

              sumThreads[i] = new SumThread(i,array,sumValue2,i*amount,amount,lock);
            
        }
        
        for (int i = 0; i < sumThreads.length; i++) {
             sumThreads[i].start();           
        }
        for (int i = 0; i < sumThreads.length; i++) {
            try {
                sumThreads[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ParallelSummation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
 
        /*
         for (int i = 0; i < sumThreads.length; i++) {
 
             globaTotal += sumValue[i].getValue();
         }
*/
         
         System.out.println("The globalTotal is "+sumValue2.getValue());
        
        
        
        
        
        
        
        
        
    }
    
}
