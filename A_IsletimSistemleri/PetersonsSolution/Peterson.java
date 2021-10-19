package A_IsletimSistemleri.PetersonsSolution;

public class Peterson {

    public static  boolean peterson = true;
    public static boolean reentrantlock = true;

    public static void main(String[] args) throws InterruptedException {
        Thread sto = new Thread(new store() );
        Thread con = new Thread(new consumer(100));
        Thread pro = new Thread(new producer(100));

        
        

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

    public store(){}

    public static int setStock(int i){

        if(stock + i < 0){
            stock = 0;
            return -stock;
        }
        
        if(stock + i > maxStock){
            stock = maxStock;
            return maxStock - stock;
        }
            

        stock = stock + i;
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

    public producer(int process){
        this.process = process;
    }

    public void produce(int i){

        int result = store.setStock(i);

        produced += result;
    }

    @Override
    public void run() {
        
               
        for (int i = 0; i < process; i++) {

            try {
                Thread.sleep((int) (Math.random()*10));
            } catch (Exception e) { }
            
            if(Peterson.peterson == true)
                Lock.lock(0);
            //Thread.yield();
            produce( (int) (Math.random()*5) );
            Lock.unLock(0);
        }
        

    }

    

}

class consumer implements Runnable {

    public static int consumed = 0;
    public int process = 1000;

    public consumer(int process){
        this.process = process;
    }

    public void run(){
        for (int i = 0; i < process; i++) {

            try {
                Thread.sleep((int) (Math.random()*10));
            } catch (Exception e) { }

            if(Peterson.peterson == true)
                Lock.lock(1);
            //Thread.yield();
            consume( (int) (Math.random()*5) );

            Lock.unLock(1);
        }
    }

    public void consume(int i){

        int result = store.setStock(-i);

            consumed += result;
        
    }


}

class Lock{

    public static boolean [] flag = new boolean [2];
    public static int turn = 0;
    

    public static void lock(int i ){

        int j = 1 - i;
 
        flag[i] = true;
        turn = j;

        while(flag[j] && turn == j);

    }

    public static void unLock(int i ){
            Lock.flag[i] = false;
    }


}
