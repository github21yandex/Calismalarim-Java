package A_IsletimSistemleri.Race;

public class UnsyncronizedBuffer implements Buffer{
    

    private int buffer = -1;
    public void set(int value){
        System.out.printf("produces writes \t %d\n", value);
        buffer = value;
    }

    public int get(){
        System.out.printf("Consumer reads \t %d \n", buffer);
        return buffer;
    }
}
