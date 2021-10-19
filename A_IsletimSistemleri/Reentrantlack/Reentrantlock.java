package A_IsletimSistemleri.Reentrantlack;

import java.util.concurrent.locks.ReentrantLock;

public class Reentrantlock {

    public static boolean reentrantlock = true;

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock rLock = new ReentrantLock();

        Thread sto = new Thread(new store(rLock) );
        Thread con = new Thread(new consumer(100, rLock));
        Thread pro = new Thread(new producer(100, rLock));

        
        

        sto.start();
        con.start();
        pro.start();

        sto.join();
        con.join();
        pro.join();

        System.out.println("SON Stock:" + store.stock);
        System.out.println("tüketilen:" + consumer.consumed);
        System.out.println("üretilen :" + producer.produced);
        System.out.println("Hata     :" + (producer.produced -(-consumer.consumed +store.stock )));
        
    }

  
}

class store implements Runnable{

    public static int stock = 0;
    public static int maxStock = 100;
    public static ReentrantLock rLock;

    public store(ReentrantLock rLock){
        store.rLock = rLock;
     }

    public static int setStock(int i){

        
        rLock.lock();

        if(stock + i < 0){
            stock = 0;
            return -stock;
        }
        
        if(stock + i > maxStock){
            stock = maxStock;
            return maxStock - stock;
        }

        stock = stock + i;
        rLock.unlock();
        

        return i;
    }

    public void run(){

        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep((int) (Math.random()*100));
            } catch (Exception e) { }

            System.out.println("Anlık Stock:" + stock);
        }       

    }
}


class producer implements Runnable  {
    
    public static int produced = 0;
    public int process = 1000;
    public ReentrantLock rLock;

    public producer(int process, ReentrantLock rLock){
        this.process = process;
        this.rLock = rLock;
    }

    public void produce(int i){

        rLock.lock();
        int result = store.setStock(i);
        rLock.unlock();

        produced += result;
    }

    @Override
    public void run() {
        
               
        for (int i = 0; i < process; i++) {

            try {
                Thread.sleep((int) (Math.random()*10));
            } catch (Exception e) { }
            
            produce( (int) (Math.random()*5) );
           
        }
        

    }

    

}

class consumer implements Runnable {

    public static int consumed = 0;
    public int process = 1000;
    public ReentrantLock rLock;

    public consumer(int process, ReentrantLock rLock){
        this.process = process;
        this.rLock = rLock;
    }

    public void run(){
        
        while(consumed != process){
            
            try {
                Thread.sleep((int) (Math.random()*10));
            } catch (Exception e) { }

           
            
            consume( (int) (Math.random()*5) );

        }
    }

    public void consume(int i){

        rLock.lock();
        int result = store.setStock(-i);
        rLock.unlock();

        consumed += result;
        
    }

}
