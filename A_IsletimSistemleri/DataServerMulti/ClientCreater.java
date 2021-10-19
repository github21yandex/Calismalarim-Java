package A_IsletimSistemleri.DataServerMulti;

public class ClientCreater {
    public static void main(String[] args) {

        int clientNumber = 10;

        Thread [] thrd = new Thread[clientNumber];


        for (int i = 0; i < 10; i++) {
            thrd[i] = new Thread( new client(i) );
            thrd[i].start();
        }



    }
}
