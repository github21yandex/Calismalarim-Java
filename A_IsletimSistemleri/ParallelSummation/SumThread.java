/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_IsletimSistemleri.ParallelSummation;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author acar
 */
public class SumThread extends Thread{
    
    private int[] array;
    private MutableInteger sumValue;
    private ReentrantLock rLock;
    
    private int from;
    private int amount;
    private int id;
    
    public SumThread (int id, int [] array, MutableInteger results,int from, int amount,ReentrantLock rLock){
        
        this.id = id;
        this.array = array;
        this.sumValue = results;
        this.from = from;
        this.amount = amount;
        this.rLock = rLock;
        System.out.println("Hello I am thread with Id"+id+ " from:"+from+" to:"+(from+amount-1));
    }
    
    @Override
    public void run(){
        
        int localSum = 0;
        int counter = 0;
        int idx = from;
        while( counter != amount && idx < array.length)
        {
            localSum +=array[idx];
            idx++;
            counter++;
        
        }
        
        rLock.lock();
        sumValue.setValue(sumValue.getValue()+localSum);
        System.out.println("I am thread "+id+" in critical section");
        rLock.unlock();
       


    }
    
    
}
