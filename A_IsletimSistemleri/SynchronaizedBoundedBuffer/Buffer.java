

package A_IsletimSistemleri.SynchronaizedBoundedBuffer;

interface Buffer <E>{
    public void insert (E item) throws InterruptedException;
    public E remove() throws InterruptedException;
    
}