package A_IsletimSistemleri.RaceCondition;

public class UnsyncronizedBuffer implements Buffer {



    private  int buffer=-1;

    public void set(int value)
    {

        System.out.printf("Produces writes \t %d\n",value);
        buffer=value;
    }
    public int get() {

        System.out.printf("Consumer reads \t %d \n",buffer);
        return buffer;
    }
}
