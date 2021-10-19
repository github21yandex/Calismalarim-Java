package A_IsletimSistemleri.ThreadMai;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("this thread is main thread");

        Thread [] thrds = new Thread[20];
        
        for (int i = 0; i < thrds.length; i++) {
            thrds[i] = new Thread( new EkranaYaz(Integer.toString(i)));
        }
        
        for (int i = 0; i < thrds.length; i++) {
            thrds[i].start();
            //thrds[i].join();
        }       
        //Thread thrd = new Thread(new EkranaYaz("0"));
        //thrd.start();

        try {
            //thrd.join();

            for (int i = 0; i < thrds.length; i++) {
               // thrds[i].join();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("This thread is main thread and over");
    }



    

}



class EkranaYaz implements Runnable{

    private String id;

    public EkranaYaz(String id){
        this.id = id;
    }



    @Override
    public void run(){
        System.out.println("this thread id is :" + id);
    }

}

