package A_IsletimSistemleri.DiningPhilosopher;

public class Philosopher implements Runnable{




    public void think(){

    }

    public void get_fork(){
       
    }

    public void eat(){

    }

    public void put_fork(){

    }

    public int left(int philosopher){
        return (philosopher + 1) % 5;
    }
    public int right(int philosopher){
        return philosopher;
    }
    
    @Override
    public void run(){
        
        while(true){

            think();
            get_fork();
            eat();
            put_fork();

        }
    }
    
}
