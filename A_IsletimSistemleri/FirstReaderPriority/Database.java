/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_IsletimSistemleri.FirstReaderPriority;

import java.util.concurrent.Semaphore;

/**
 *
 * @author acar
 */
 class Database implements RWLock{
      private int readerCount;  // the number of active readers
      private Semaphore mutex;  // controls access to readerCount
      private Semaphore db;     // controls access to the database
   
       public Database() {
         readerCount = 0;
         mutex = new Semaphore(1);
         db = new Semaphore(1);
      }
   
       public void acquireReadLock(int readerNum) {
         try{
         //mutual exclusion for readerCount 
            mutex.acquire();
         }
             catch (InterruptedException e) {}
      
         ++readerCount;
      
      // if I am the first reader tell all others
      // that the database is being read
         if (readerCount == 1){
            try{
               db.acquire();
            }
                catch (InterruptedException e) {}
         }
      
         System.out.println("Reader " + readerNum + " is reading. Reader count = " + readerCount);
         //mutual exclusion for readerCount
         mutex.release();
      }
   
       public void releaseReadLock(int readerNum) {
         try{
         //mutual exclusion for readerCount
            mutex.acquire();
         }
             catch (InterruptedException e) {}
      
         --readerCount;
      
      // if I am the last reader tell all others
      // that the database is no longer being read
         if (readerCount == 0){
            db.release();
         }
      
         System.out.println("Reader " + readerNum + " is done reading. Reader count = " + readerCount);
      
      //mutual exclusion for readerCount
         mutex.release();
      }
   
       public void acquireWriteLock(int writerNum) {
         try{
            db.acquire();
         }
             catch (InterruptedException e) {}
         System.out.println("Writer " + writerNum + " is writing.");
      }
   
       public void releaseWriteLock(int writerNum) {
         System.out.println("Writer " + writerNum + " is done writing.");
         db.release();
      }
   
   
   }

