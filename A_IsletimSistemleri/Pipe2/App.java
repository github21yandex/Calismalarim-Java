package A_IsletimSistemleri.Pipe2;



class Sayi {

    int x = 0;

    public void add(){
        x++;
        
    }
}

class Flag {
    static boolean flag = false;
}

public class App {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {

            Sayi sayi = new Sayi();
            Flag flag = new Flag();
            Flag.flag = false;
    
            Thread t2 = new Thread(new thrd2(sayi, flag));
            Thread t1 = new Thread(new thrd1(sayi, flag));

           
    
            t1.start();
            t2.start();

            t1.join();
            t2.join();
            System.out.println("\n");
            
        }


    }

}

class thrd1 implements Runnable {

    Sayi sayi;
    Flag flag;
  

    public thrd1(Sayi sayi, Flag flag) {
        this.sayi = sayi;
        this.flag = flag;
    }

   
    @Override
    public void run() {

        //try { Thread.sleep(1);  } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("W_"+ Flag.flag);
        
        while (Flag.flag == false) {;
            if(Flag.flag);
            //System.out.println("W_"+ Flag.flag);
        };
        
        System.out.println("thrd_1" + " x=" + sayi.x);
    }
    
}

class thrd2 implements Runnable {

    Sayi sayi;
    Flag flag;
   
    public thrd2(Sayi sayi, Flag flag){
        this.sayi = sayi;
        this.flag = flag;
    }

 


    @Override
    public void run() {
       // try {  Thread.sleep(10);   } catch (InterruptedException e) { e.printStackTrace();  }

        sayi.add();
        Flag.flag = true;
       
        //System.out.println("true");
    }
    
}