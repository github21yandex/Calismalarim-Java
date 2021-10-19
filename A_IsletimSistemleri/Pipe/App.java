package A_IsletimSistemleri.Pipe;

public class App {

    public static void main(String[] args) {

        Thread t1 = new Thread(new thrd(1, 2));
        Thread t2 = new Thread(new thrd(2, 2));

        t1.start();
        t2.start();
      


    }
    
}

class thrd implements Runnable {

    static int x = 0;
    int thrdnumber;
    int count;
    static boolean flag;

    public thrd(int thrdnumber, int count){
        this.thrdnumber = thrdnumber;
        this.count = count;
    }

    @Override
    public void run() {
        
        
        for (int i = 0; i < count; i++) {
            
            while(flag);
            flag = true;

            System.out.println("thrd_"+ thrdnumber + " x=" + x);
            x++;
            System.out.println("thrd_"+ thrdnumber + " x=" + x);

            flag = false;
        }

    }
    
}
