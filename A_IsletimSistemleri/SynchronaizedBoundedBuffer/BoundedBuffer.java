package A_IsletimSistemleri.SynchronaizedBoundedBuffer;


import java.util.concurrent.Semaphore;

public class BoundedBuffer<E> implements Buffer<E> {
    
    private static final int BUFFER_SIZE= 5;
    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore full;

    private int count;
    private int in, out;
    private E[] buffer;

    @SuppressWarnings("unchecked")
    
    public BoundedBuffer(){
        count = 0;
        in = 0;
        out = 0;
        
        buffer = (E[]) new Object [BUFFER_SIZE];

        mutex = new Semaphore(1);
        empty = new Semaphore(BUFFER_SIZE);
        full = new Semaphore(0);

        



    }

    @Override
    public void insert(E item) throws InterruptedException {
        empty.acquire();
        mutex.acquire();

        //critical section

        ++count;
        buffer[in] = item;
        in = ( in +1 ) % BUFFER_SIZE;

        if(count == BUFFER_SIZE){
            System.out.println("The buffer is FULL");

        }
        System.out.println("Producer inserts " + item + "item" + count + " count");
        mutex.release();
        full.release();
    }

    @Override
    public E remove() throws InterruptedException {
        
        full.acquire();

        mutex.acquire();

        --count;

        E item = buffer[out];

        out = (out + 1 ) % BUFFER_SIZE;

        if (count == 0)
            System.out.println("THe buffer is empty");
        else
            System.out.println("consumer removes" + item + "count" + count);
        
        mutex.release();
        empty.release();
        return item;
    }
}
