package A_IsletimSistemleri.Semaphore;

import java.util.concurrent.Semaphore;

public class App {

    public static boolean semafor = true;

    public static void main(String[] args) throws InterruptedException {

        Semaphore smphr = new Semaphore(1);

        

        Thread adder = new Thread(new Adder(100, smphr));
        Thread minuser = new Thread(new Minuser(100, smphr));
        adder.start();
        minuser.start();

        adder.join();
        minuser.join();

        System.out.println("toplam eklenen sayi   :" + Adder.added);
        System.out.println("toplam çıkarılan sayi :" + Minuser.extracted);
        System.out.println("genel toplam değişkeni:" + Sum.sum);
        System.out.println("Hata miktarı          :" + (Sum.sum - (Adder.added - Minuser.extracted)));

    }
}

class Minuser implements Runnable {

    public Semaphore smphr;
    public static int extracted = 0;
    public static int process = 1000;

    public Minuser(int process, Semaphore smphr) {
        Minuser.process = process;
        this.smphr = smphr;
    }

    public void minus() throws InterruptedException {

        int num = (int) (Math.random() * 10);

        if(App.semafor == true)
        smphr.acquire();
        Sum.sum += -num;
        if(App.semafor == true)
        smphr.release();

        extracted += num;

    }

    @Override
    public void run() {
        for (int i = 0; i < process; i++) {

            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (Exception e) {
            }

            try {
                minus();
            } catch (InterruptedException e) { }
        }

    }
}

class Adder implements Runnable {

    public Semaphore smphr;
    public static int added = 0;
    public static int process;

    public Adder(int process, Semaphore smphr) {
        this.smphr = smphr;
        Adder.process = process;
    }

    public void add() throws InterruptedException {
        int num = (int) (Math.random() * 10);

        if(App.semafor == true)
        smphr.acquire();
        Sum.sum += num;
        if(App.semafor == true)
        smphr.release();

        added += num;

    }

    @Override
    public void run() {

        for (int i = 0; i < process; i++) {

            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (Exception e) { }

            try {
                add();
            } catch (InterruptedException e) {}
        }

    }
    
}

class Sum{

    public static int sum = 0;

}
